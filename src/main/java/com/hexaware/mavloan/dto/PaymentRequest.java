package com.hexaware.mavloan.dto;

public class PaymentRequest {
    private int loanAvailedId;
    private double amountPaid;
    private String paymentMode;

    // getters and setters
    public int getLoanAvailedId() {
        return loanAvailedId;
    }
    public void setLoanAvailedId(int loanAvailedId) {
        this.loanAvailedId = loanAvailedId;
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
}

