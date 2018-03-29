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
	
	/*@Test
	public void shouldSaveCategory(){
		
		category = new Category();
		category.setName("TV");
		category.setDescription("Used in Entertainment");
		category.setImageUrl("cat3.png");
		
		assertEquals("Not able to save category in database!", true, categoryDao.add(category));
	}
	
	@Test
	public void shouldAddNewCategory(){
		category = new Category();
		category.setName("Laptop");
		category.setDescription("GOod For COding");
		category.setImageUrl("CAT_LP_1");
		
		assertEquals("Not able to save category in database!", true, categoryDao.add(category));
	}*/
	
	@Test
	public void shouldPerformCategoryCRUD(){
		
		/*category = new Category();
		category.setName("Mens Wear");
		category.setDescription("Jeans is good for casual");
		category.setImageUrl("JN_CAT_1");
		
		assertEquals("Not able to add new category",true,categoryDao.add(category));
		
		category = new Category();
		category.setName("Womens Wear");
		category.setDescription("Suit is good for Traditional");
		category.setImageUrl("SU_CAT_1");
		
		assertEquals("Not able to add new category",true,categoryDao.add(category));
		
		//Fetch and update category
		Category category2 = categoryDao.get(3);
		
		category2.setDescription("Good for Entertainment");
		assertEquals("Not able to update category2",true,categoryDao.update(category2));
		*/
		
		Category category2 = categoryDao.get(5);
		//delete the category
		assertEquals("Not able to delete the category",true,categoryDao.delete(category2));
		
		//fetching the list of category
		assertEquals("Not able to fetch category list",4,categoryDao.list());
	
	}

}
