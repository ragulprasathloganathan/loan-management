package com.hexaware.mavloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.LoanAvailable;
import com.hexaware.mavloan.repository.LoanAvailableRepository;

@Service
public class LoanAvailableService {
	
	@Autowired
	private LoanAvailableRepository loanAvailableRepository;

	//add New loan
	public LoanAvailable postLoan(LoanAvailable loanAvailable) {
		
		return loanAvailableRepository.save(loanAvailable) ;
	}

	//update Available loan
	public LoanAvailable editLoan(int loanNumber, LoanAvailable editedLoan) {
	
		LoanAvailable existingLoan = loanAvailableRepository.findById(loanNumber)
	    .orElseThrow(() -> new RuntimeException("Loan not found with number: \" + loanNumber"));
		
		existingLoan.setLoanType(editedLoan.getLoanType());
	    existingLoan.setLoanName(editedLoan.getLoanName());
	    existingLoan.setLoanDescription(editedLoan.getLoanDescription());
	    existingLoan.setLoanRoi(editedLoan.getLoanRoi());
	
		return loanAvailableRepository.save(existingLoan);
	}

	//get Available loan By loanNumber - get Single available loan
	public LoanAvailable viewLoan(int loanNumber) {
		
		return loanAvailableRepository.findById(loanNumber)
		.orElseThrow(() -> new RuntimeException("Loan not found"));
	}

	
	//delete Available loan
	public ResponseEntity<?> deleteLoan(int loanNumber) {
	    LoanAvailable loan = loanAvailableRepository.findById(loanNumber)
	        .orElseThrow(() -> new RuntimeException("Loan not found with number: " + loanNumber));

	    loanAvailableRepository.delete(loan);

	    return ResponseEntity.ok("Loan with number " + loanNumber + " has been deleted successfully.");
	}

	//get all available loans
	public List<LoanAvailable> getAllAvailableLoans() {
        return loanAvailableRepository.findAll();
    }

	
}
