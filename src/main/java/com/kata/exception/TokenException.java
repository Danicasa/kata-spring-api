package com.kata.exception;

import org.springframework.http.HttpStatus;

public class TokenException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
	
	public static HttpStatus getHttpstatus() {
		return httpStatus;
	}

	public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
