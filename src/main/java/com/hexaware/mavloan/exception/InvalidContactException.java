package com.hexaware.mavloan.exception;

public class InvalidContactException  extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;
	
	
	public InvalidContactException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}
}
