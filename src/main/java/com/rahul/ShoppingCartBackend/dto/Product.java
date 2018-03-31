package com.rahul.ShoppingCartBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
public class Product implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;//1
	
	@NotBlank(message = "Can not leave this field without entering value")
	@Size(min = 3, message = "Field must contain greater than 3 characters")
	private String brand;//2
   
	//@NotBlank(message = "Can not leave this field without entering value")
	boolean  activeIs;//3

	

	@NotBlank(message = "Can not leave this field without entering value")
	@Size(min = 3, message = "Field must contain greater than 3 characters")
	private String description;//of product//4
	
	@NotBlank(message = "Can not leave this field without entering value")
	@Size(min = 3, message = "Field must contain greater than 3 characters")
	private String name;//name of product//5
	
	@NotBlank(message = "Can not leave this field without entering value")
	@Size(min = 3, message = "Field must contain greater than 3 characters")
	private String supplier;//supplier name//6
	
	
	private String image_url;//product image//7
	
	@Range(min=1 ,max = 2000 , message = " the quantity of product with supllier must between 1-2000")
	private int quantity;/*quantity with the supplier*///8
	
	@Range(min=1 ,max = 200000 , message = " the price of product  must between 1-2,00,000")
	private int price;//price of single piece//9
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private CartItem cartItem;
	
	public CartItem getCartItem() {
		return cartItem;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", activeIs=" + activeIs + ", description=" + description
				+ ", name=" + name + ", supplier=" + supplier + ", image_url=" + image_url + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	public boolean isActiveIs() {
		return activeIs;
	}

	public void setActiveIs(boolean activeIs) {
		this.activeIs = activeIs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	
	
}
