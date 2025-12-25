package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer>
{
	Vendor findByMail(String mail);
	Vendor findByMailAndPassword(String mail, String password);
}
