package com.vivek.app.ecommercebackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vivek.app.ecommercebackend.dao.CategoryDao;
import com.vivek.app.ecommercebackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	@BeforeClass
	public static void setUp(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.vivek.app.ecommercebackend");
		context.refresh();
		
		categoryDao =context.getBean(CategoryDao.class);
	}
	
	@Test
	public void shouldSaveCategory(){
		
		category = new Category();
		category.setName("Mobile Phone");
		category.setDescription("Used to catpute images");
		category.setImageUrl("cat1.png");
		
		assertEquals("Not able to save category in database!", true, categoryDao.add(category));
	}

}
