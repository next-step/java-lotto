package com.hskim.lotto.exception;

public class CalculatorException extends RuntimeException {

    private CalculatorExceptionType calculatorExceptionType;
    private String message;

    public CalculatorException(CalculatorExceptionType calculatorExceptionType) {

        this.calculatorExceptionType = calculatorExceptionType;
        message = calculatorExceptionType.getMessage();
    }

    public String getMessage() {

        return message;
    }
}
