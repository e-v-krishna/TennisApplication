package com.test.tennis.exception;

public class GameNotInitException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Game is not initialized";

    public GameNotInitException() {
        super(MESSAGE);
    }
}
