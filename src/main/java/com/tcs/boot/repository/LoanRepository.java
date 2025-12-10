package com.tcs.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.boot.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
