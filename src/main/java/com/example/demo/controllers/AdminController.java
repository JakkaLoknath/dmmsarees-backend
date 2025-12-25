package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;
import com.example.demo.entities.Vendor;
import com.example.demo.services.AdminService;

@RestController
@CrossOrigin(origins = {
				"http://localhost:5173",
				"https://dmmsarees-frontend.vercel.app"
})
public class AdminController 
{
	private AdminService adminService;
	
	public AdminController(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	@PostMapping("/getadmin")
	public Admin getAdmin(@RequestBody Admin admin)
	{
		return adminService.searchAdmin(admin.getMail(), admin.getPassword());
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers()
	{
		return adminService.getAllUsers();
	}
	
	@GetMapping("/getvendors")
	public List<Vendor> getVendors()
	{
		return adminService.getAllVendors();
	}
	
	@DeleteMapping("/deleteuserandusercart/{userid}")
	public void removeUserAndUserCart(@PathVariable int userid)
	{
		adminService.deleteUserAndUserCart(userid);
	}
	
	@DeleteMapping("/deletevendorandvendorproducts/{vendorid}")
	public void removeVendorAndVendorProducts(@PathVariable int vendorid)
	{
		adminService.deleteVendorAndVendorProducts(vendorid);
	}
}
