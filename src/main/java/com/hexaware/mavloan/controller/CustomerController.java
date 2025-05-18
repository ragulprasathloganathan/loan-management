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

import com.hexaware.mavloan.dto.PaymentRequest;
import com.hexaware.mavloan.entity.Customer;
import com.hexaware.mavloan.entity.LoanApplication;
import com.hexaware.mavloan.entity.LoanAvailable;
import com.hexaware.mavloan.service.CustomerService;
import com.hexaware.mavloan.service.LoanApplicationService;
import com.hexaware.mavloan.service.LoanAvailableService;
import com.hexaware.mavloan.service.PaymentTransactionService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final LoanApplicationService loanApplicationService_1;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private  LoanAvailableService loanAvailableService;
    
    @Autowired
    private LoanApplicationService  loanApplicationService;
    
    @Autowired
    private PaymentTransactionService paymentTransactionService;
    
    


    CustomerController(LoanApplicationService loanApplicationService_1) {
        this.loanApplicationService_1 = loanApplicationService_1;
    }
    

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    
    @PutMapping("/{customerId}/link-user/{userId}")
    public ResponseEntity<String> linkUser(@PathVariable int customerId, @PathVariable int userId) {
        customerService.linkUserToCustomer(customerId, userId);
        return ResponseEntity.ok("User linked to customer successfully.");
    }
    
    //Customer can view All Available loans
    @GetMapping("/available/loans")
    public List<LoanAvailable> getAllAvailableLoans() {
        return loanAvailableService.getAllAvailableLoans();
    }
    
    //Customer can apply for loan
    // Apply for a loan with existing customerId and loanAvailableId
    @PostMapping("/apply/{customerId}/{loanAvailableId}")
    public LoanApplication applyLoan(
            @PathVariable int customerId,@PathVariable int loanAvailableId,@RequestBody double requestedAmount) throws Exception 
    {
        return loanApplicationService.applyLoan(customerId, loanAvailableId, requestedAmount);
    }
    
    //Customer need to pay emi upon approval and emi schedule
    @PostMapping("/pay-emi")
    @Transactional
    public ResponseEntity<String> payEmi(@RequestBody PaymentRequest request) {
        paymentTransactionService.payEmi(request.getLoanAvailedId(), request.getAmountPaid(), request.getPaymentMode());
        return ResponseEntity.ok("EMI payment successful");
    }
}
