package com.hexaware.mavloan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationNo;
	
	@Column(nullable=false)
	private double requestedAmount;
	
	@Column(nullable = false)
	private String status;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private LoanAvailable loanAvailable;

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoanAvailable getLoanAvailable() {
		return loanAvailable;
	}

	public void setLoanAvailable(LoanAvailable loanAvailable) {
		this.loanAvailable = loanAvailable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
