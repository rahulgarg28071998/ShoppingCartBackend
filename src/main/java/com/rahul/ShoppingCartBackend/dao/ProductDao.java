package com.rahul.ShoppingCartBackend.dao;

import java.util.List;

import com.rahul.ShoppingCartBackend.dto.Product;

public interface ProductDao {

	public Product getProduct(int id);

	public List <Product> productList();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(int id);

	boolean isActive(int id);

}
