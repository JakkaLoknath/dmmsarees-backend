package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserCart;

@Repository
public interface UserCartRepo extends JpaRepository<UserCart, Integer>
{
	UserCart findByUseridAndProductid(int userid, int productid);
	List<UserCart> findByUserid(int userid);
	void deleteAllByUserid(int userid);
}
