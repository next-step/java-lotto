package com.hskim.lotto.calculator.exception;

public class CalculatorException extends RuntimeException {

    private String message;

    public CalculatorException(CalculatorExceptionType calculatorExceptionType) {
        message = calculatorExceptionType.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
