package com.lotto.exception;

public class LottoNumberOutOfBoundsException extends RuntimeException {
    private static final String MESSAGE = "로또번호 범위(1~45)를 벗어났습니다. 번호:";

    public LottoNumberOutOfBoundsException(int wrongNumber) {
        super(MESSAGE + wrongNumber);
    }

    public LottoNumberOutOfBoundsException(String message) {
        super(message);
    }
}
