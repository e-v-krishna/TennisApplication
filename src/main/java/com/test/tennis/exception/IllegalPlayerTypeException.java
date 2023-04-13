package com.test.tennis.exception;

public class IllegalPlayerTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public IllegalPlayerTypeException(String message) {
        super(message);
    }
}
