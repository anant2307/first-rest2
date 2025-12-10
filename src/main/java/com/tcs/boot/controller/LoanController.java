package com.tcs.boot.controller;

import java.io.Console;
import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.boot.model.Loan;
import com.tcs.boot.service.LoanService;

@RestController
@RequestMapping("/loan/api/v1.0")
public class LoanController {

	@Autowired
	LoanService service;
	// http://localhost:9090/loan/api/v1.0/create

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan) {

		Loan newLoan = service.addLoan(loan);

		HttpHeaders headers = new HttpHeaders();

		headers.add("xx-created-by", "anant shukla");
		headers.add("content-type", "application/json");
		return new ResponseEntity<Loan>(newLoan, headers, HttpStatus.CREATED);
	}

	@GetMapping("/loan/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable long id) {
		Loan loan = service.getLoan(id);

		if (loan != null) {
			return ResponseEntity.ok(loan);
		} else {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	public List<Loan> getLoan() {
		return service.getLoan();
	}

	@PutMapping("/modify") // for complete update
	public ResponseEntity<Loan> doUpdate(@RequestBody Loan loan) {
		Loan updatedLoan = service.update(loan);

		if (updatedLoan != null) {
			return ResponseEntity.ok(updatedLoan); 
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}

	@PutMapping("/modify2")
	public Loan doUpdate2(@RequestBody Loan loan) {
		return service.update2(loan);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		return new ResponseEntity<>(HttpStatusCode.valueOf(204));
	}

}
