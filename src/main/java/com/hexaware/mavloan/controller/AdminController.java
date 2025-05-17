package com.hexaware.mavloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.mavloan.entity.Admin;
import com.hexaware.mavloan.entity.LoanApplication;
import com.hexaware.mavloan.service.AdminService;
import com.hexaware.mavloan.service.LoanApplicationService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired 
    private LoanApplicationService loanApplicationService;

    //adding admin
    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin)
    {
    	return adminService.addAdmin(admin);
    }
    
    //Admin can view All loan application submitted by Customer
    @GetMapping("/view/all/application")
    public List<LoanApplication> viewAllLoanApplication()
    {
    	return loanApplicationService.viewAllLoanApplication() ;
    }
    
    //Admin can approve loan ,upon approval a new entry will be created in loan availed.
    @PutMapping("/loan-application/{applicationNo}/approve")
    public ResponseEntity<String> approveLoan(@PathVariable int applicationNo) {
    String result = adminService.approveLoanApplication(applicationNo);
     return ResponseEntity.ok(result);
    }
    
    //Admin can reject loans 
    @PutMapping("/loan-application/reject/{applicationNo}")
    public ResponseEntity<String> rejectLoanApplication(@PathVariable int applicationNo) {
        String response = adminService.rejectLoanApplication(applicationNo);
        return ResponseEntity.ok(response);
    }
}