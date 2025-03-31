package com.nextstep.camp.calculator.domain.exception;

public class InvalidExpressionException extends IllegalArgumentException {

    private static final String MESSAGE = "잘못된 수식입니다.";

    public InvalidExpressionException() {
        super(MESSAGE);
    }
}
