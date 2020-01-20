package com.java.exception;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7390803973407931373L;
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
