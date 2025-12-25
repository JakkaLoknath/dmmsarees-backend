package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;
import com.example.demo.entities.Vendor;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
	User findByMail(String mail);
	User findByMailAndPassword(String mail, String password);
}
