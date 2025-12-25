package com.example.demo.services;

import java.util.List;
import com.example.demo.repos.VendorRepo;
import org.springframework.stereotype.Service;

import com.example.demo.entities.VendorProduct;
import com.example.demo.repos.VendorProductRepo;

@Service
public class VendorProductService 
{

	private VendorProductRepo productRepo;
	
	public VendorProductService(VendorProductRepo productRepo)
	{
		this.productRepo = productRepo;
	}
	
	public VendorProduct addVendorProduct(VendorProduct product)
	{
		return productRepo.save(product);
	}
	
	public VendorProduct updateVendorProduct(VendorProduct product)
	{
		return productRepo.save(product);
	}
	
	public String deleteProductById(int id)
	{
		productRepo.deleteById(id);
		return "Deleted";
	}
	
	public VendorProduct getProductById(int id)
	{
		return productRepo.findById(id).orElse(null);
	}
	
	public List<VendorProduct> getProductsByVendorId(int id)
	{
		return productRepo.findByVendorId(id);
	}
	
	public byte[] getImageById(int id)
	{
		VendorProduct product = productRepo.findById(id).orElse(null);
		return product.getImage();
	}
	
	public List<VendorProduct> getAllProducts()
	{
		return productRepo.findAll();
	}
}
