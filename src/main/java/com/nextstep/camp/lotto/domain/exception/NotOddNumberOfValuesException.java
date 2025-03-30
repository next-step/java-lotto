package com.nextstep.camp.lotto.domain.exception;

public class NotOddNumberOfValuesException extends RuntimeException {

    private static final String MESSAGE = "입력값의 개수가 홀수여야 합니다.";

    public NotOddNumberOfValuesException() {
        super(MESSAGE);
    }
}
