package com.rapipay.loan.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rapipay.loan.Product.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
//	public Product findByProductName(String productName);

	public Product findByProductName(String productName);

}
