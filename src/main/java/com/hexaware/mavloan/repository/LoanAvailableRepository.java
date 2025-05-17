package com.hexaware.mavloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.LoanAvailable;


public interface LoanAvailableRepository extends JpaRepository<LoanAvailable, Integer>{

	
}
