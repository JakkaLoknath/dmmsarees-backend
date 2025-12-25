package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserCart;
import com.example.demo.services.UserCartService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserCartController 
{
	private UserCartService userCartService;
	
	public UserCartController(UserCartService userCartService)
	{
		this.userCartService = userCartService;
	}
	
	@PostMapping("/addtocart")
	public UserCart addToCart(@RequestBody UserCart usercart)
	{
		return userCartService.saveOrUpdate(usercart);
	}
	
	@GetMapping("/getcart/{userid}/{productid}")
	public UserCart searchProduct(@PathVariable int userid, @PathVariable int productid)
	{
		return userCartService.getProduct(userid, productid);
	}
	
	@GetMapping("/getallcart/{userid}")
	public List<UserCart> getAllCart(@PathVariable int userid)
	{
		return userCartService.getAllCartProducts(userid);
	}
	
	@DeleteMapping("/deletecartproduct/{id}")
	public void deleteCartProduct(@PathVariable int id)
	{
		userCartService.deleteProduct(id);
	}
}
