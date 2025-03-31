package com.nextstep.camp.calculator.domain.exception;

public class NotFoundValueException extends RuntimeException {

    private static final String MESSAGE = "값을 찾을 수 없습니다.";

    public NotFoundValueException() {
        super(MESSAGE);
    }
}
