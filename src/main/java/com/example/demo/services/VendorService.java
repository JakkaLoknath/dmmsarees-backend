package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Vendor;
import com.example.demo.repos.VendorRepo;

@Service
public class VendorService 
{
	private VendorRepo repo;
	
	public VendorService(VendorRepo repo)
	{
		this.repo = repo;
	}
	
	public String addVendor(Vendor vendor)
	{
		Vendor v = getByMail(vendor);
		if(v == null)
		{
			repo.save(vendor);
			return "ADDED";
		}
		return "VENDOR WITH MAIL EXISTS";
	}
	
	public Vendor getByMail(Vendor vendor)
	{
		return repo.findByMail(vendor.getMail());
	}
	
	public Vendor getByNameandPassword(String mail, String password)
	{
		Vendor v = repo.findByMailAndPassword(mail, password);
		
		if(v == null)
		{
			return null;
		}
		
		return v;
	}
	
	public Vendor getVendorById(int id)
	{
		return repo.findById(id).orElse(null);
	}
}
