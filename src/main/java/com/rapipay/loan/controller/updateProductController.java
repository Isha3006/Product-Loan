package com.rapipay.loan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.loan.Product.Product;
import com.rapipay.loan.Services.ProductServices;

@RestController
public class updateProductController {
	
	@Autowired
	public ProductServices proServices;
	
	@RequestMapping(method = RequestMethod.POST,value ="updateProduct")
    public String updateProduct(@RequestParam Integer id, @RequestBody(required = false) Product newProduct) {
		
		return proServices.updateProduct(id, newProduct);
    	
    	
    }
    
    

}
