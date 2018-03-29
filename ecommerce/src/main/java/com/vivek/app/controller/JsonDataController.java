package com.vivek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vivek.app.ecommercebackend.dao.ProductDao;
import com.vivek.app.ecommercebackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(value="/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDao.listActiveProducts();
	}
	
	@RequestMapping(value="/category/{id}/products")
	@ResponseBody
	public List<Product> getCategoryProducst(@PathVariable int id){
		return productDao.listActiveProductsByCategory(id);
	}
}
