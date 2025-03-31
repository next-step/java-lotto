package com.nextstep.camp.calculator.domain.exception;

public class UnsupportedOperandException extends RuntimeException {

    private static final String MESSAGE = "지원하지 않는 피연산자입니다.";

    public UnsupportedOperandException() {
        super(MESSAGE);
    }
}
