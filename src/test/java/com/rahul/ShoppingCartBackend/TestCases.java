package com.rahul.ShoppingCartBackend;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.ShoppingCartBackend.dao.*;
import com.rahul.ShoppingCartBackend.daoImpl.ProductDaoImpl;
import com.rahul.ShoppingCartBackend.dto.*;

public class TestCases {

	private static AnnotationConfigApplicationContext context;
	private static CartDao cartDao;
	private static CartItemDao cartItemDao;
	private static UserDao userDao;
	private static ProductDao productDao;
	private User user;
	private Cart cart;
	private CartItem cartItem;
	private Product product, pro;
	private Payment payment;
	 private static PaymentDao paymentDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.ShoppingCartBackend");
		context.refresh();

		cartDao = (CartDao) context.getBean("cartDao");
		cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		userDao = (UserDao) context.getBean("userDao");
		productDao = (ProductDao) context.getBean("productDao");

		paymentDao = (PaymentDao) context.getBean("PaymentDaoImpl");

	}
//	
//	@Test//add user test1
//	public void t1()
//	{
//		 user = new User();
//		 user.setContact("9988556677");
//		 //user.setUser_id(20);
//		 user.setEmail("admin4@gmail.com");
//		 user.setEnabled(true);
//		 user.setName("admin4.jpg");
//		 user.setPassword("admin4");
//		 user.setRole("ADMIN");
//		 user.setAddress("Delhi");
//		 assertEquals("Successfully added the User!",true, userDao.add(user));
//	}
//	
//	@Test//update user test2
//	public void t2()
//	{
//		user = new User();
//		user=userDao.getUserById(54);
//		user.setAddress("delhi-123");
//		assertEquals("Successfully updated the User!", true, userDao.update(user));
//	}
	
//	@Test//delete user test 3  "not working"
//	public void t3(){
//		user = new User();
//		assertEquals("Successfully deleted the User!", true, userDao.delete("admin4@gmail.com	"));
//		
//	}
	
	
	@Test//add product test4
	public void t4() {
		 product = new Product();
		 product.setActiveIs(true);
		 product.setBrand("Krishna Packers");
		 product.setDescription("This is the paper box");
		 //product.setId(34);
		 product.setName("128*128");
		 product.setPrice(500);
		 product.setImage_url("abc");
		 product.setQuantity(20);
		 product.setSupplier("kp");
		 productDao.add(product);
		assertEquals("Successfully added the product!",  productDao.add(product));
		}
	
//	@Test//update product test 5
//	public void t5() {
//		 product = new Product();
//		 product=productDao.getProduct(56);
//		 product.setPrice(1000);
//		 assertEquals("Successfully updated the product!", true, productDao.update(product));
//		 
//	}
	
//	@Test//test 4 delete product
//	public void t6()
//	{
//		assertEquals("Successfully updated the product!", true, productDao.delete(10));	 
//	}
	

//	 @Test// to delete all cartItems of a cart related to a user
//	 public void t7() {
//	 	user = userDao.getUserById(3);
//	 	cart = user.getCart();
//	 	assertEquals("Successfully deleted the cartItems!", true,
//	 	cartDao.deleteAllCartItems(cart));
//	 }
	
//	@Test//get cart item by user and product id
//	public void t8() {
//		user = userDao.getUserById(1);
//		product = productDao.getProduct(1);  
//		cart = user.getCart();
//		cartItem = cartItemDao.getCartItemByUserIdAndProductId(cart, product);
//		System.out.println("Cart " + cartItem.getCart().getCartItemCount());
//		System.out.println(cartItem.getProduct().getName());
//	}
	
	

//	 @Test// Adding new Product//
//	 public void t9() {
//	 product = new Product();
//	 
//	 product.setActiveIs(true);
//	 product.setBrand("Medifast");
//	 product.setDescription("This is the Medifast photo frame");
//	//product.setId(23);
//	 product.setName("Medifast Photo Frame");
//	 product.setPrice(500);
//	 product.setImage_url("WIN_20170820_212853 (2).jpg");
//	 product.setQuantity(20);
//	 product.setSupplier("Mumbai Hut");
//	 productDao.add(product);
//	
//	
//	 assertEquals("Successfully added the product!", true, productDao.add(product));
//	 
//	
//	 user = userDao.getUserById(41);
//	 cartItem = new CartItem();
//	 cartItem.setCart(user.getCart());
//	 cartItem.setProduct(product);
//	 cartItem.setSell_quantity(4);
//	 cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
//	 cart = user.getCart();
//	 cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
//	 cart.setCartItemCount(cart.getCartItemCount() + 1);
//	
//	 assertEquals("Successfully added the cartItem!", true,cartItemDao.addCartItem(cartItem));System.out.println("hello");
//	 }
	
	
	
//	 @Test// Delete existing product quantity from cartItem
//	 public void t10() {
//	 cartItem = cartItemDao.getCartItemByCartItem_Id(46);
//	 cart = cartItem.getCart();
//	 product = cartItem.getProduct();
//	 int oldQuantity = cartItem.getSell_quantity();
//	 cartItem.setSell_quantity(cartItem.getSell_quantity() - 1);
//	 cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
//	 cart.setGrandTotal(cart.getGrandTotal() - (oldQuantity - cartItem.getSell_quantity()) * product.getPrice());
//	 assertEquals("Successfully Update the cartItem!", true,cartItemDao.updateCartItem(cartItem));
//	 }
	
	 
	
//	 @Test// Add product quantity by one in existing product
//	 public void t11() {
//	 cartItem = cartItemDao.getCartItemByCartItem_Id(46);
//	 cart = cartItem.getCart();
//	 product = cartItem.getProduct();
//	 int oldQuantity = cartItem.getSell_quantity();
//	 cartItem.setSell_quantity(cartItem.getSell_quantity() + 1);
//	 cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
//	 cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getSell_quantity() -
//	 oldQuantity) * product.getPrice());
//	 assertEquals("Successfully Update the cartItem!", true,cartItemDao.updateCartItem(cartItem));
//	 }
	
	 
//	 @Test// create and insert data, create user first time with cart object which is available in dao class
//	 public void t12() {
//	 user = new User();
//	 user.setContact("9988556677");
//	// user.setUser_id(20);
//	 user.setEmail("admin4@gmail.com");
//	 //user.setEnabled(true);
//	 user.setName("admin4.jpg");
//	 user.setPassword("admin4");
//	 user.setRole("ADMIN");
//	 user.setAddress("Delhi");
//	
//	 product = new Product();
//	 product.setActiveIs(true);
//	 product.setBrand("Meilleour2");
//	 product.setDescription("This is the Meilleour photo frame2");
//	 product.setName("Nature2");
//	 product.setPrice(2000);
//	 product.setImage_url("abc2");
//	 product.setQuantity(20);
//	 product.setSupplier("Jindal & sons");
//	
//	//assertEquals("Successfully added the User!", true, userDao.add(user));
//	//assertEquals("Successfully added the product!", true,productDao.add(product));
//	
//	 cartItem = new CartItem();
//	 cartItem.setCart(user.getCart());
//	
//	 product.setCartItem(cartItem); 
//	 cartItem.setProduct(product);
//	 cartItem.setSell_quantity(5);
//	 cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
//	
//	 cart = user.getCart();
//	 cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
//	 cart.setCartItemCount(cart.getCartItemCount() + 1);
//	
//	 assertEquals("Successfully added the cartItem!", true,cartItemDao.addCartItem(cartItem));
//	
//	 }
	
	
//	@Test//search user
//	public void t13(){
//		user = new User();
//		
//		user.setName("rahul");
//		user.setEmail("rgarg8438@gmail.com");
//		user.setPassword("1234");
//		user.setAddress("d-3/65,secotr-11,rohini");
//		user.setRole("USER");
//		user.setContact("9311032818");
//		user.setEnabled(true);
//		assertEquals("Successfully added the User!", true, userDao.add(user));
//		
//		user = userDao.getUserById(35);
//		
//		System.out.println(user.getUser_id());
//		System.out.println(user.getRole());
//		System.out.println(user.getEmail());
//		System.out.println(user.getContact());
//		System.out.println(user.getName());
//		System.out.println(user.getAddress());
//	}

		@Test
			public void t14()
			{	System.out.println("hello");
				product=productDao.getProduct(58);
				System.out.println(product.getName());
				assertEquals("Successfully added the User!", "128*128",product.getName());
//				
			}

}
