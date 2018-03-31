package com.rahul.ShoppingCartBackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ShoppingCartBackend.dao.PaymentDao;
import com.rahul.ShoppingCartBackend.dto.Payment;
import com.rahul.ShoppingCartBackend.dto.User;

@Repository("PaymentDaoImpl")
@Transactional
public class PaymentDaoImpl  implements PaymentDao {
	@Autowired
	SessionFactory sessionFactory;


	public Payment getPaymentDetails(User user) {
		return (Payment) sessionFactory.getCurrentSession().createQuery("from Payment where user=:user")
				.setParameter("user", user).getSingleResult();

	}

	public boolean add(Payment payment) {
		try {
			sessionFactory.getCurrentSession().save(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
