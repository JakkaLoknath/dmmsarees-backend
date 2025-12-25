package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	Admin getByMailAndPassword(String mail, String password);
}
