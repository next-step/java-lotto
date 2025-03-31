package com.nextstep.camp.calculator.domain.exception;

public class NotStartWithNumberException extends IllegalArgumentException {
    private static final String NOT_START_WITH_NUMBER_EXCEPTION_MESSAGE = "첫 토큰은 숫자여야 합니다.";

    public NotStartWithNumberException() {
        super(NOT_START_WITH_NUMBER_EXCEPTION_MESSAGE);
    }
}
