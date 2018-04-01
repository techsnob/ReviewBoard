package com.techsnob.exceptions;

public class UserNotFoundByNameException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserNotFoundByNameException() {
		super();
	}

	public UserNotFoundByNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundByNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundByNameException(String message) {
		super(message);
	}

	public UserNotFoundByNameException(Throwable cause) {
		super(cause);
	}
	
	

}
