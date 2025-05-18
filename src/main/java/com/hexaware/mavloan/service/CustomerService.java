package com.hexaware.mavloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.Customer;
import com.hexaware.mavloan.entity.User;
import com.hexaware.mavloan.repository.AuthRepository;
import com.hexaware.mavloan.repository.CustomerRepository;

@Service
public class CustomerService {
	
	 @Autowired
	 private CustomerRepository customerRepository;
	 @Autowired 
	 private AuthRepository authRepository;

	public Customer addCustomer(Customer customer) {
		 return customerRepository.save(customer);
	}

	public void linkUserToCustomer(int customerId, int userId) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        User user = authRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        customer.setUser(user);
        customerRepository.save(customer);
    }
}
