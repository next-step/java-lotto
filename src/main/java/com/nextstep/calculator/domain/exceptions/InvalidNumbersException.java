package com.nextstep.calculator.domain.exceptions;

public class InvalidNumbersException extends RuntimeException {
    public InvalidNumbersException(String message) {
        super(message);
    }
}
