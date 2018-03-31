package com.rahul.ShoppingCartBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -4906912674192274404L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;// 1

	@NotBlank(message = "Please enter your name!")
	private String name;// 2
	@NotBlank(message = "Please enter email address!")
	@Column(unique = true)
	private String email;// 3
	@NotBlank(message = "Please enter password!")
	private String password;// 4

	@NotBlank(message = "Please enter Address!")
	private String address;// 5

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user") // , mappedBy="user"
	private Cart cart;// 6

	@NotBlank(message = "Please enter role of user!")
	private String role;// 4

	@NotBlank(message = "Please enter Contact!")
	@Size(min = 10, message = "Field must contain 10 digits")
	private String contact;// 7


	private boolean enabled;
	
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", cart=" + cart + ", role=" + role + ", contact=" + contact + "]";
	}

}
