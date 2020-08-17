package com.hskim.calculator.exception;

public enum CalculatorExceptionType {

    CONTAINS_NO_NUMERIC("Non-numeric values exist"),
    CONTAINS_NEGATIVE_NUMERIC("Negative-numeric values exist");

    private String message;

    CalculatorExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
