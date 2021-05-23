package com.lotto.exception;

public class IllegalInputException extends RuntimeException {
    private static final String MESSAGE = "잘못된 입력값 입니다.";

    public IllegalInputException() {
        super(MESSAGE);
    }

    public IllegalInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
