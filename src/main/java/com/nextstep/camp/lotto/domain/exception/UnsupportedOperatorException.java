package com.nextstep.camp.lotto.domain.exception;

public class UnsupportedOperatorException extends RuntimeException {

    private static final String MESSAGE = "지원하지 않는 연산자입니다.";

    public UnsupportedOperatorException() {
        super(MESSAGE);
    }
}
