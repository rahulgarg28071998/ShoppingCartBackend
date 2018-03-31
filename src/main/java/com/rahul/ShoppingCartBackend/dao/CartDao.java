package com.rahul.ShoppingCartBackend.dao;

import com.rahul.ShoppingCartBackend.dto.Cart;

public interface CartDao {

	public boolean updateCart(Cart cart);
	public Cart getCartBycart_Id(int cart_Id);
	public boolean deleteAllCartItems(Cart cart);
}
