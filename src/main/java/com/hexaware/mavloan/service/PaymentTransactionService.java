package com.hexaware.mavloan.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.EMISchedule;
import com.hexaware.mavloan.entity.LoanAvailed;
import com.hexaware.mavloan.entity.PaymentTransaction;
import com.hexaware.mavloan.repository.EMIScheduleRepository;
import com.hexaware.mavloan.repository.LoanAvailedRepository;
import com.hexaware.mavloan.repository.PaymentTransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentTransactionService {

	@Autowired
	private LoanAvailedRepository loanAvailedRepository;
	@Autowired
	private EMIScheduleRepository emiScheduleRepository;
	@Autowired
	private PaymentTransactionRepository paymentTransactionRepository;
	
	@Transactional
	public void payEmi(int loanAvailedId, double amountPaid, String paymentMode) {
	    LoanAvailed loan = loanAvailedRepository.findById(loanAvailedId)
	        .orElseThrow(() -> new RuntimeException("Loan not found"));

	    // Step 1: Find next pending EMI
	    EMISchedule nextEmi = emiScheduleRepository.findFirstByLoanAvailedAndStatusOrderByDueDate(loan, "PENDING")
	        .orElseThrow(() -> new RuntimeException("No pending EMI found"));

	    // Step 2: Check payment amount
	    if (amountPaid < nextEmi.getEmiAmount()) {
	        throw new RuntimeException("Payment is less than EMI amount");
	    }

	    // Step 3: Create payment transaction
	    PaymentTransaction payment = new PaymentTransaction();
	    payment.setLoanAvailed(loan);
	    payment.setAmountPaid(amountPaid);
	    payment.setPaymentDate(LocalDate.now());
	    payment.setPaymentMode(paymentMode);
	    payment.setPaymentType("EMI");
	    paymentTransactionRepository.save(payment);

	    // Step 4: Update EMI schedule
	    nextEmi.setStatus("PAID");
	    nextEmi.setPaymentDate(LocalDate.now());
	    nextEmi.setPaymentTransaction(payment);
	    emiScheduleRepository.save(nextEmi);

	    // Step 5: Update loan availed
	    loan.setPaidTenure(loan.getPaidTenure() + 1);
	    loan.setPendingTenure(loan.getTotalTenure() - loan.getPaidTenure());
	    loan.setOutstandingAmount(loan.getOutstandingAmount() - nextEmi.getEmiAmount());
	    loanAvailedRepository.save(loan);
	}

}
