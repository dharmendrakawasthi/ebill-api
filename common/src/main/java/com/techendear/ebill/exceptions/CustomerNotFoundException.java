package com.techendear.ebill.exceptions;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(Long id) {
		super("Customer not found by id "+ id);
	}
	
	public CustomerNotFoundException() {
		super("Customer not found");
	}
}
