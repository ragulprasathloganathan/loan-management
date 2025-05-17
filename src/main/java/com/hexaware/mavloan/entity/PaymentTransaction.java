package com.hexaware.mavloan.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private LoanAvailed loanAvailed;

    private LocalDate paymentDate;

    private double amountPaid;

    private String paymentMode; // "UPI", "NET_BANKING", "CREDIT_CARD"

    private String paymentType; // "EMI".

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

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
    
    

}
