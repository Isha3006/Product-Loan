package com.rapipay.loan.Product;

import org.springframework.web.bind.annotation.*;
import com.rapipay.loan.Product.Repository.ProductRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/")

public class Controller {
	
	@Autowired
	public ProductRepository productRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "insertLoanProduct")
    public String insertLoanProduct(@RequestBody Product loanProduct) {
    	productRepo.saveAndFlush(loanProduct);
    	return "Product saved sucessfully";
    }

    @RequestMapping(method = RequestMethod.GET, value="getProduct")
    public Product getProduct(@RequestParam Integer id) {
    	return productRepo.findById(id).orElse(new Product());
//    	return productRepo.findByProductName(productName);
    	
    }

    @RequestMapping(method = RequestMethod.POST,value ="updateProduct")
    public Product updateProduct(@RequestParam Integer id, @RequestBody(required = false) Product newProduct) {
		
    	Product product= productRepo.findById(id).orElse(null);
    	if(product==null)
    		return product;
        if(newProduct.getProductName()!=null){
            product.setProductName(newProduct.getProductName());
        }
        if(newProduct.getPrincipleAmount()!=null){
            product.setPrincipleAmount(newProduct.getPrincipleAmount());
        }
        if(newProduct.getTenure()!=null){
            product.setTenure(newProduct.getTenure());
        }
        if(newProduct.getIsActive()!=null){
            product.setIsActive(newProduct.getIsActive());
        }
        if(newProduct.getCreatedBy()!=null){
            product.setCreatedBy(newProduct.getCreatedBy());
        }
        if(newProduct.getCreatedOn()!=null){
            product.setCreatedOn(newProduct.getCreatedOn());
        }
        
        if(newProduct.getRoi()!=null){
            product.setRoi(newProduct.getRoi());
        }
        if(newProduct.getUpdatedBy()!=null){
            product.setUpdatedBy(newProduct.getUpdatedBy());
        }
        product.setUpdatedOn(getCurrentTime());
        productRepo.save(product);
        return  product;
    	
    }
    
    private String getCurrentTime() {
		// TODO Auto-generated method stub
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
	}

	@RequestMapping(method= RequestMethod.GET, value="calculateEmi")
    public String calculateEmi(@RequestParam Integer ProductId) {
    	Product product = productRepo.findById(ProductId).orElse(null);
    	if(product==null)
    		return "no product exists for this id";
    	else {
	    	Double principleAmount = product.getPrincipleAmount().doubleValue();
	    	Double roi= product.getRoi().doubleValue();
			Integer tenure=product.getTenure();
			
			Double emi=principleAmount*roi*(1+roi)*tenure/((1+roi))*tenure-1;
			return "Emi of this product is: " + String.valueOf(emi);
    	}
    	
    }
    
    

}
