package com.rahul.ShoppingCartBackend.dao;

import java.util.List;

import com.rahul.ShoppingCartBackend.dto.Cart;
import com.rahul.ShoppingCartBackend.dto.CartItem;
import com.rahul.ShoppingCartBackend.dto.Product;

public interface CartItemDao {
	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(int cartItem_Id);

	public CartItem getCartItemByCartItem_Id(int cartItem_Id);

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);

	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product);
}
