package com.nextstep.camp.lotto.domain.exception;

public class UnsupportedTokenTypeException extends RuntimeException {

    private static final String MESSAGE = "지원하지 않는 토큰 타입입니다.";

    public UnsupportedTokenTypeException() {
        super(MESSAGE);
    }
}
