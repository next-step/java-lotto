package com.hskim.lotto.exception;

public enum CalculatorExceptionType {

    CONTAINS_NO_NUMERIC("temp"),
    CONTAINS_NEGATIVE_NUMERIC("temp");

    private String message;

    CalculatorExceptionType(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
