package com.hexaware.mavloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}