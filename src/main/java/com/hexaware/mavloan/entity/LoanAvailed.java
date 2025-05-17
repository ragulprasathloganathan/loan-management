package com.hexaware.mavloan.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class LoanAvailed {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne
	    private Customer customer;

	    @ManyToOne
	    private LoanAvailable loanAvailable;

	    @OneToOne
	    private LoanApplication loanApplication;

	    @Column(nullable = false)
	    private double principalAmount;

	    @Column(nullable = false)
	    private double outstandingAmount;

	    @Column(nullable = false)
	    private double rateOfInterest;

	    @Column(nullable = false)
	    private LocalDate startDate;

	    @Column(nullable = false)
	    private LocalDate endDate;

	    @Column(nullable = false)
	    private int totalTenure;

	    @Column(nullable = false)
	    private int paidTenure;

	    @Column(nullable = false)
	    private int pendingTenure;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public LoanApplication getLoanApplication() {
			return loanApplication;
		}

		public void setLoanApplication(LoanApplication loanApplication) {
			this.loanApplication = loanApplication;
		}

		public double getPrincipalAmount() {
			return principalAmount;
		}

		public void setPrincipalAmount(double principalAmount) {
			this.principalAmount = principalAmount;
		}

		public double getOutstandingAmount() {
			return outstandingAmount;
		}

		public void setOutstandingAmount(double outstandingAmount) {
			this.outstandingAmount = outstandingAmount;
		}

		public double getRateOfInterest() {
			return rateOfInterest;
		}

		public void setRateOfInterest(double rateOfInterest) {
			this.rateOfInterest = rateOfInterest;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public int getTotalTenure() {
			return totalTenure;
		}

		public void setTotalTenure(int totalTenure) {
			this.totalTenure = totalTenure;
		}

		public int getPaidTenure() {
			return paidTenure;
		}

		public void setPaidTenure(int paidTenure) {
			this.paidTenure = paidTenure;
		}

		public int getPendingTenure() {
			return pendingTenure;
		}

		public void setPendingTenure(int pendingTenure) {
			this.pendingTenure = pendingTenure;
		}
	    
	    
}
