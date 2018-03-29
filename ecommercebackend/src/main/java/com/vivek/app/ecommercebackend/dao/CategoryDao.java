package com.vivek.app.ecommercebackend.dao;

import java.util.List;

import com.vivek.app.ecommercebackend.dto.Category;

public interface CategoryDao {
	
	Category get(int id);
	boolean add(Category category);
	List<Category> list();
	boolean update(Category category);
	boolean delete(Category category);
	

}
