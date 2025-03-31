package com.nextstep.camp.calculator.domain.exception;

public class TooShortExpressionException extends RuntimeException {

    private static final String MESSAGE = "입력값이 너무 짧습니다.";

    public TooShortExpressionException() {
        super(MESSAGE);
    }
}
