package com.hexaware.mavloan.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.mavloan.entity.Admin;
import com.hexaware.mavloan.entity.EMISchedule;
import com.hexaware.mavloan.entity.LoanApplication;
import com.hexaware.mavloan.entity.LoanAvailed;
import com.hexaware.mavloan.repository.AdminRepository;
import com.hexaware.mavloan.repository.EMIScheduleRepository;
import com.hexaware.mavloan.repository.LoanApplicationRepository;
import com.hexaware.mavloan.repository.LoanAvailedRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

	@Autowired
    private AdminRepository adminRepository;
	@Autowired
	private LoanAvailedRepository loanAvailedRepository;
	@Autowired
    private LoanApplicationRepository loanApplicationRepository;
	@Autowired
	private EMIScheduleRepository emiScheduleRepository;


	
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }


    @Transactional
    public String approveLoanApplication(int applicationNo) {
        // Fetch the loan application by ID or throw exception if not found
        LoanApplication loanApp = loanApplicationRepository.findById(applicationNo)
            .orElseThrow(() -> new RuntimeException("Loan Application not found"));

        // Check if already processed
        if (!"PENDING".equalsIgnoreCase(loanApp.getStatus())) {
            return "Loan application already processed.";
        }

        // Mark application as APPROVED
        loanApp.setStatus("APPROVED");
        loanApplicationRepository.save(loanApp);

        // Create new LoanAvailed entry
        LoanAvailed loanAvailed = new LoanAvailed();

        // Set linked entities
        loanAvailed.setLoanApplication(loanApp); // OneToOne with LoanApplication
        loanAvailed.setCustomer(loanApp.getCustomer()); // ManyToOne with Customer
        loanAvailed.setLoanAvailable(loanApp.getLoanAvailable()); // ManyToOne with LoanAvailable

        // Set loan financials
        double principalAmount = loanApp.getRequestedAmount();
        double interestRate = loanApp.getLoanAvailable().getLoanRoi(); 

        loanAvailed.setPrincipalAmount(principalAmount);
        loanAvailed.setOutstandingAmount(principalAmount); 
        loanAvailed.setRateOfInterest(interestRate);

        // Set loan duration and dates
        int totalTenureMonths = 36; 
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(totalTenureMonths);

        loanAvailed.setStartDate(startDate);
        loanAvailed.setEndDate(endDate);
        loanAvailed.setTotalTenure(totalTenureMonths);
        loanAvailed.setPaidTenure(0);
        loanAvailed.setPendingTenure(totalTenureMonths);

        // Save the availed loan record
        loanAvailedRepository.save(loanAvailed);
        
     // Calculate EMI amount using standard EMI formula
        double monthlyInterestRate = interestRate / (12 * 100); // monthly interest rate in decimal
        double emiAmount = (principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalTenureMonths))
                            / (Math.pow(1 + monthlyInterestRate, totalTenureMonths) - 1);

        // Create EMI schedule entries
        for (int i = 1; i <= totalTenureMonths; i++) {
            EMISchedule emi = new EMISchedule();
            emi.setLoanAvailed(loanAvailed);
            emi.setDueDate(startDate.plusMonths(i));
            emi.setEmiAmount(emiAmount);
            emi.setStatus("PENDING");
            emiScheduleRepository.save(emi);
        }

        return "Loan application approved and loan availed record created and EMI scheduled.";
    }
    
    
    
    
    //Reject Loan
    public String rejectLoanApplication(int applicationNo) {
        // Fetch the loan application
        LoanApplication loanApp = loanApplicationRepository.findById(applicationNo)
            .orElseThrow(() -> new RuntimeException("Loan Application not found"));

        // Check if already processed
        if (!"PENDING".equalsIgnoreCase(loanApp.getStatus())) {
            return "Loan application already processed with status: " + loanApp.getStatus();
        }

        // Set status to REJECTED
        loanApp.setStatus("REJECTED");

        // Save updated application
        loanApplicationRepository.save(loanApp);

        return "Loan application has been rejected.";
    }

}
