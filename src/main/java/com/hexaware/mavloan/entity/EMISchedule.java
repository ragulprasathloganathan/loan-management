package com.hexaware.mavloan.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class EMISchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private LoanAvailed loanAvailed;

    private LocalDate dueDate;

    private double emiAmount;

    private String status; // "PENDING", "PAID", "OVERDUE"

    private LocalDate paymentDate;

    @OneToOne
    private PaymentTransaction paymentTransaction; // Linked when paid

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoanAvailed getLoanAvailed() {
		return loanAvailed;
	}

	public void setLoanAvailed(LoanAvailed loanAvailed) {
		this.loanAvailed = loanAvailed;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentTransaction getPaymentTransaction() {
		return paymentTransaction;
	}

	public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
		this.paymentTransaction = paymentTransaction;
	}
    
    
}

