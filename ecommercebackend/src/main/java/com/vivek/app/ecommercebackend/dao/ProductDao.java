package com.vivek.app.ecommercebackend.dao;

import java.util.List;

import com.vivek.app.ecommercebackend.dto.Product;

public interface ProductDao {
	
	Product get(int productId);
	List<Product> listProducts();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	//business logic
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
