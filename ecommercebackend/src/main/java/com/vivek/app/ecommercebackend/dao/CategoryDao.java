package com.vivek.app.ecommercebackend.dao;

import com.vivek.app.ecommercebackend.dto.Category;

public interface CategoryDao {
	
	
	boolean add(Category category);

	Category list();

}
