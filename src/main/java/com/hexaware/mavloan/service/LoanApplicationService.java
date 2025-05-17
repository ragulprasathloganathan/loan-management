package com.hexaware.mavloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.Customer;
import com.hexaware.mavloan.entity.LoanApplication;
import com.hexaware.mavloan.entity.LoanAvailable;
import com.hexaware.mavloan.repository.CustomerRepository;
import com.hexaware.mavloan.repository.LoanApplicationRepository;
import com.hexaware.mavloan.repository.LoanAvailableRepository;

@Service
public class LoanApplicationService {

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoanAvailableRepository loanAvailableRepository;
	
	//New loan application entry with existing customer and existing available loan
	public LoanApplication applyLoan(int customerId, int loanAvailableId, double requestedAmount) {
	    Customer customer = customerRepository.findById(customerId)
	        .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

	    
	    LoanAvailable loanAvailable = loanAvailableRepository.findById(loanAvailableId)
	        .orElseThrow(() -> new RuntimeException("Loan available not found with id: " + loanAvailableId));

	    LoanApplication application = new LoanApplication();
	    application.setCustomer(customer);
	    application.setLoanAvailable(loanAvailable);
	    application.setRequestedAmount(requestedAmount);

	    return loanApplicationRepository.save(application);
	}

	//View All loan Application submitted by customer 
	public List<LoanApplication> viewAllLoanApplication() {
		
		return loanApplicationRepository.findAll() ;
	}

	
}
