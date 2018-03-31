package com.rahul.ShoppingCartBackend.dao;

import com.rahul.ShoppingCartBackend.dto.Payment;
import com.rahul.ShoppingCartBackend.dto.User;

public interface PaymentDao {

	public Payment getPaymentDetails(User user);
	public boolean add(Payment payment);

}
