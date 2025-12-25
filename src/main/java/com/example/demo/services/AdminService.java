package com.example.demo.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;
import com.example.demo.entities.Vendor;
import com.example.demo.repos.AdminRepo;
import com.example.demo.repos.UserCartRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.repos.VendorProductRepo;
import com.example.demo.repos.VendorRepo;

import jakarta.transaction.Transactional;

@Service
public class AdminService 
{
	private AdminRepo adminRepo;
	private UserRepo userRepo;
	private UserCartRepo userCartRepo;
	private VendorRepo vendorRepo;
	private VendorProductRepo vendorProductRepo;
	
	public AdminService(AdminRepo adminRepo,
						UserRepo userRepo, 
						VendorRepo vendorRepo,
						UserCartRepo userCartRepo,
						VendorProductRepo vendorProductRepo
	)
	{
		this.adminRepo = adminRepo;
		this.userRepo = userRepo;
		this.vendorRepo = vendorRepo;
		this.userCartRepo = userCartRepo;
		this.vendorProductRepo = vendorProductRepo;
	}
	
	public Admin searchAdmin(String mail, String password)
	{
		return adminRepo.getByMailAndPassword(mail, password);
	}
	
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	public List<Vendor> getAllVendors()
	{
		return vendorRepo.findAll();
	}
	
	@Transactional
	public void deleteUserAndUserCart(int id)
	{
		userCartRepo.deleteAllByUserid(id);
		userRepo.deleteById(id);
	}
	
	@Transactional
	public void deleteVendorAndVendorProducts(int vendorid)
	{
		vendorProductRepo.deleteAllByVendorId(vendorid);
		vendorRepo.deleteById(vendorid);
	}
}
