package com.vivek.app.ecommercebackend.daoimpl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vivek.app.ecommercebackend.dao.CategoryDao;
import com.vivek.app.ecommercebackend.dto.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean add(Category category) {

		try{
				//add category to database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Category list() {
		// TODO Auto-generated method stub
		return null;
	}

}
