package com.tcs.boot.service;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.boot.model.Loan;
import com.tcs.boot.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository repository;
	
	public Loan addLoan(Loan loan) {
		return repository.save(loan);
	}
	
	public Loan getLoan(long id) {
		Optional<Loan> loanOptional=repository.findById(id);
		if(loanOptional.isPresent()) {
		return loanOptional.get();
	}
		else {
			return null;
		}
	}

	public List<Loan> getLoan() {
		return repository.findAll();
	}

	public Loan update(Loan loan) {
		return repository.save(loan);
	}
	
	public Loan update2(Loan loan) {
		
		Optional<Loan> optional = repository.findById(loan.getLoanId());
		Loan tempLoan = optional.get();
		
		if(loan.getBorrower() != null) {
			tempLoan.setBorrower(loan.getBorrower());
		}
		if(loan.getDateborrowed() != null) {
			tempLoan.setDateborrowed(loan.getDateborrowed());
		}
		if (tempLoan.getTenure() != loan.getTenure()) {
			tempLoan.setTenure(loan.getTenure());
		}
		if(tempLoan.getAmount() < loan.getAmount()) {
			tempLoan.setAmount(loan.getAmount());
		}
		if(tempLoan.isLoanStatus() != loan.isLoanStatus()) {
			tempLoan.setLoanStatus(loan.isLoanStatus());
		}
		return repository.save(tempLoan);
	}
	
	public void remove(long id) {
		
		Optional<Loan> loan = repository.findById(id);
		if(loan.isPresent()) {
		repository.deleteById(id);
	}else {
		throw new IllegalArgumentException("Id not found");
	}
	}
}
