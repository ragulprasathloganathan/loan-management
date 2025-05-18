package com.hexaware.mavloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.User;

public interface AuthRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username); 
}
