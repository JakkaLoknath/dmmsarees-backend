package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.UserCart;
import com.example.demo.repos.UserCartRepo;

@Service
public class UserCartService 
{
	private UserCartRepo userCartRepo;
	
	public UserCartService(UserCartRepo userCartRepo)
	{
		this.userCartRepo = userCartRepo;
	}
	
	public UserCart saveOrUpdate(UserCart usercart)
	{
		return userCartRepo.save(usercart);
	}
	
	public UserCart getProduct(int userid, int productid)
	{
		return userCartRepo.findByUseridAndProductid(userid, productid);
	}
	
	public List<UserCart> getAllCartProducts(int id)
	{
		return userCartRepo.findByUserid(id);
	}
	
	public void deleteProduct(int id)
	{
		userCartRepo.deleteById(id);
	}
}
