package com.rahul.ShoppingCartBackend.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ShoppingCartBackend.dao.UserDao;
import com.rahul.ShoppingCartBackend.dto.Cart;
import com.rahul.ShoppingCartBackend.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	
	public User getUserByUsername(String email) {
		String selectUserId = "FROM User where email=:parameter";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		query.setParameter("parameter", email);
		try {

			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
		// return sessionFactory.getCurrentSession().get(User.class,
		// email); This line execute on primary key not on others
	}

	
	public User getUserById(int user_id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(user_id));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean add(User user) {
		try {
			// Mapping OneToOne
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			// add the User to the database
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

		public boolean update(User user) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	
	public boolean delete(String email) {
		User user = getUserByUsername(email);
		//user.setEnabled(false);
		try {
			// Delete the User to the database
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
