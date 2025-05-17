package com.hexaware.mavloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.PaymentTransaction;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Integer> {
    
}
