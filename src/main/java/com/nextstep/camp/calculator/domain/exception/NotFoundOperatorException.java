package com.nextstep.camp.calculator.domain.exception;

public class NotFoundOperatorException extends RuntimeException {

    private static final String MESSAGE = "연산자를 찾을 수 없습니다.";

    public NotFoundOperatorException() {
        super(MESSAGE);
    }
}
