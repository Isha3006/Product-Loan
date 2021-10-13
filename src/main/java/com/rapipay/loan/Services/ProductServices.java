package com.rapipay.loan.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.loan.Product.Product;
import com.rapipay.loan.Product.Repository.ProductRepository;
import com.rapipay.loan.controller.calculateEmiController;
import com.rapipay.loan.controller.getProductController;
import com.rapipay.loan.controller.insertLoanProductController;
import com.rapipay.loan.controller.updateProductController;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepo;
	
	public String insertLoanProduct(Product product){
		productRepo.saveAndFlush(product);
		return "Product insert sucessfully "+ product.toString();  
		
	}
	
	public String getProduct(Integer id) {
		
		if(productRepo.findById(id)!=null)
			return productRepo.findById(id).toString();
		else
			return "This id doesn't exits";
	}
	
	public String updateProduct(Integer id, Product newProduct) {
		
		Product product= productRepo.findById(id).orElse(null);
    	if(product==null)
    		return "cannot found";
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
        return  product.toString();
	
		
	}
	
	private String getCurrentTime() {
		// TODO Auto-generated method stub
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
	}

	
	public String calculateEmi(Integer ProductId){
		
		Product product = productRepo.findById(ProductId).orElse(null);
		if(product==null)
    		return "no product exists for this id "+ProductId;
    	else {
	    	Double principleAmount = product.getPrincipleAmount().doubleValue();
	    	Double roi= product.getRoi().doubleValue();
			Integer tenure=product.getTenure();
			Double emi=principleAmount*roi*(1+roi)*tenure/((1+roi))*tenure-1;
			return "Emi of this product is: " + String.valueOf(emi);
    	}
		
	}
	
	

}
