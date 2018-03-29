package com.vivek.app.ecommercebackend.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vivek.app.ecommercebackend.dao.CategoryDao;
import com.vivek.app.ecommercebackend.dto.Category;

@Repository
@Transactional
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
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public List<Category> list() {
			String selectCategoryQuery = "From Category Where active =:active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectCategoryQuery);
			query.setParameter("active", true);
			
		return query.getResultList();
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
