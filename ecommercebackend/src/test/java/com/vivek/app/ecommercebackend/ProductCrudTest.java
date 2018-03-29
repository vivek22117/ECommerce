package com.vivek.app.ecommercebackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vivek.app.ecommercebackend.dao.ProductDao;
import com.vivek.app.ecommercebackend.dto.Product;


public class ProductCrudTest {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	
	private Product product;
	
	@BeforeClass
	public static void setUp(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.vivek.app.ecommercebackend");
		context.refresh();
		productDao =context.getBean(ProductDao.class);
	}
	
	@Test
	public void testCRUDProduct(){
		product = new Product();
		
		product.setName("Sony Bravia");
		product.setBrand("Sony");
		product.setCategoryId(4);
		product.setDescription("Best HD");
		product.setActive(true);
		product.setSupplierId(1);
		product.setUnitPrice(2500000);
		product.setPurchases(1);
		product.setQuantity(20);
		
		Assert.assertEquals("Product cannot be added", true, productDao.addProduct(product));
		
		product = new Product();
		
		product.setName("Lenovo HP 3GB Ram");
		product.setBrand("Lenovo");
		product.setCategoryId(3);
		product.setDescription("Best laptop");
		product.setActive(true);
		product.setSupplierId(6);
		product.setUnitPrice(45000);
		product.setPurchases(3);
		product.setQuantity(10);
		
		Assert.assertEquals("Product cannot be added", true, productDao.addProduct(product));
	}

}
