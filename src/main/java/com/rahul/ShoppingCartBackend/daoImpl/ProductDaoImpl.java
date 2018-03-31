package com.rahul.ShoppingCartBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ShoppingCartBackend.dao.ProductDao;
import com.rahul.ShoppingCartBackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;


	public Product getProduct(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));

	}

	public List<Product> productList() {
		String selectActiveCategory = "FROM Product WHERE ActiveIs = :ActiveIs";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("ActiveIs", true);
		return query.getResultList();
		}

	public boolean add(Product product) {
		try {
			// add the Product to the database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		return false;
	}

	}

	public boolean update(Product product) {
		try {
			// add the Product to the database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		return false;
	}

	}

	public boolean delete(int id) {
		Product product = getProduct(id);
		
		try
		{
			// Delete the product to the database
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		return false;
	}


	}

	public boolean isActive(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
