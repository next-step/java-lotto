package com.nextstep.camp.calculator.domain.exception;

public class NotFoundOperandException extends RuntimeException {

    private static final String MESSAGE = "피연산자를 찾을 수 없습니다.";

    public NotFoundOperandException() {
        super(MESSAGE);
    }
}
