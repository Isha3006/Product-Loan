package com.rapipay.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.loan.Product.Product;
import com.rapipay.loan.Product.Repository.ProductRepository;
import com.rapipay.loan.Services.ProductServices;

@RestController
public class getProductController {
	@Autowired
	public ProductServices proServices;
	
	@RequestMapping(method = RequestMethod.GET, value="getProduct")
    public String getProduct(@RequestParam Integer id) {
		
		return proServices.getProduct(id);
		
    	
    	
    }

}
