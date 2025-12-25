package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.VendorProduct;

@Repository
public interface VendorProductRepo extends JpaRepository<VendorProduct, Integer>
{
	List<VendorProduct> findByVendorId(int vendorId);
	void deleteAllByVendorId(int vendorId);
}
