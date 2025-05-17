package com.hexaware.mavloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.mavloan.entity.LoanAvailable;
import com.hexaware.mavloan.service.LoanAvailableService;

@RestController
@RequestMapping("/api/loan")
public class LoanAvailableController {

	@Autowired
	private LoanAvailableService loanAvailableService;
	
	//Admin can Post New Loan	
     @PostMapping("/add")
     public LoanAvailable postLoan(@RequestBody LoanAvailable loanAvailable)
     {
    	 return loanAvailableService.postLoan(loanAvailable);
     }
	
     //Admin can Edit existing available Loan   
     @PutMapping("/edit/{loanNumber}")
     public LoanAvailable editLoan(@PathVariable int loanNumber, 
    		 @RequestBody LoanAvailable editedLoan)
     {
    	 return loanAvailableService.editLoan(loanNumber, editedLoan);
     }
  
     //Admin can View availabale single Loan     
     @GetMapping("/view/{loanNumber}")
     public LoanAvailable viewLoan(@PathVariable int loanNumber)
     {
    	 return loanAvailableService.viewLoan(loanNumber);
     }
     
     //Admin can delete Existing loanLoan
     @DeleteMapping("/remove/{loanNumber}")
     public ResponseEntity<?> deleteLoan(@PathVariable int loanNumber) {
    	    return loanAvailableService.deleteLoan(loanNumber);
    	}
	
}
