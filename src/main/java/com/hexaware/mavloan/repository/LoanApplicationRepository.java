package com.hexaware.mavloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {

}
