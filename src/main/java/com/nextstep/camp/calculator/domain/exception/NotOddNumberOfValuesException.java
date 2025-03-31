package com.nextstep.camp.calculator.domain.exception;

public class NotOddNumberOfValuesException extends IllegalArgumentException {

    private static final String MESSAGE = "입력값의 개수가 홀수여야 합니다.";

    public NotOddNumberOfValuesException() {
        super(MESSAGE);
    }
}
