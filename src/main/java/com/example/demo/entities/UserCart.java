package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usercart")
public class UserCart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int userid;
	
	@Column
	private int productid;
	
	@Column
	private int quantity;

	public UserCart(int id, int userid, int productid, int quantity) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.quantity = quantity;
	}

	public UserCart(int userid, int productid, int quantity) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.quantity = quantity;
	}

	public UserCart() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
