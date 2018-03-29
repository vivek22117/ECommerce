package com.vivek.app.ecommercebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vivek.app.ecommercebackend.dao.ProductDao;
import com.vivek.app.ecommercebackend.dto.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

//	private static final Logger
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> listProducts() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Product", Product.class).getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setActive(false);
			this.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectQueryByActive = "From Product where isActive = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQueryByActive,Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectQueryByActiveAndCategory = "From Product where isActive = :active And categoryId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQueryByActiveAndCategory,Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("From Product where isActive = :active ORDER BY id",Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
			}

}
