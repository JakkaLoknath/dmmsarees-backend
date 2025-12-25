package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Vendor;
import com.example.demo.services.VendorService;

@RestController
@CrossOrigin(origins = {
		"http://localhost:5173",
		"https://dmmsarees-frontend.vercel.app"
})
public class VendorController 
{
	private VendorService service;
	
	public VendorController(VendorService service)
	{
		this.service = service;
	}
	
	@PostMapping("/addvendor")
	public String newVendor(@RequestBody Vendor vendor)
	{
		return service.addVendor(vendor);
	}
	
	@PostMapping("/getvendor")
	public Vendor getVendor(@RequestBody Vendor vendor
	)
	{
		return service.getByNameandPassword(vendor.getMail(), vendor.getPassword());
	}
	
	@GetMapping("/getvendor/{id}")
	public Vendor getVendor(@PathVariable int id)
	{
		return service.getVendorById(id);
	}
}
