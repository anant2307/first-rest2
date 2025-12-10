package com.tcs.boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanId;
	private String borrower;
	private String  dateborrowed;
	private double amount;
	private int tenure;
	private int balancedEMI;
	private boolean loanStatus;
	

}
