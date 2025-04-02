package com.nextstep.camp.lotto.domain.exception;

public class NotNumberFormatStringException extends RuntimeException {

    private static final String MESSAGE = "숫자 형식의 문자열이 아닙니다.";

    public NotNumberFormatStringException() {
        super(MESSAGE);
    }
}
