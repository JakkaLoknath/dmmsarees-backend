package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.entities.Vendor;
import com.example.demo.repos.UserRepo;

@Service
public class UserService 
{
	private UserRepo userRepo;
	
	public UserService(UserRepo userRepo)
	{
		this.userRepo = userRepo;
	}
	
	public String userRegister(User user)
	{
		User u = getByMail(user);
		if(u == null)
		{
			userRepo.save(user);
			return "ADDED";
		}
		return "USER WITH MAIL EXISTS";
	}
	
	public User getByMail(User user)
	{
		return userRepo.findByMail(user.getMail());
	}
	
	public User userLogin(String mail, String password)
	{
		return userRepo.findByMailAndPassword(mail, password);
	}
}
