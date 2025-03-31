package com.nextstep.camp.calculator.domain.exception;

public class NotFoundInputException extends IllegalArgumentException {

    private static final String MESSAGE = "입력값을 찾을 수 없습니다.";

    public NotFoundInputException() {
        super(MESSAGE);
    }
}
