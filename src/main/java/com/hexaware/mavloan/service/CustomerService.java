package com.hexaware.mavloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.Customer;
import com.hexaware.mavloan.repository.CustomerRepository;

@Service
public class CustomerService {
	
	 @Autowired
	 private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		 return customerRepository.save(customer);
	}

}
