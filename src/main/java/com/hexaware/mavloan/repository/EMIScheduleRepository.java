package com.hexaware.mavloan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.mavloan.entity.EMISchedule;
import com.hexaware.mavloan.entity.LoanAvailed;

public interface EMIScheduleRepository extends JpaRepository<EMISchedule, Integer> {
    Optional<EMISchedule> findFirstByLoanAvailedAndStatusOrderByDueDate(LoanAvailed loanAvailed, String status);
}
