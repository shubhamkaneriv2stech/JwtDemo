package com.jwt.exception;


//User Defined Exception Class
public class BadCrendentialsException extends RuntimeException {

	  private static final long serialVersionUID = -1871142390742648323L;

	  public BadCrendentialsException(String studentId) {
	    super(studentId);
	  }

	  public BadCrendentialsException(Throwable cause) {
	    super(cause);
	  }

	  public BadCrendentialsException(String message, Throwable cause) {
	    super(message, cause);
	  }
	}