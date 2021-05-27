package com.lotto.exception;

public class IllegalLottoCountException extends RuntimeException {
    private static final String MESSAGE = "로또 번호는 6개여야만 합니다.";

    public IllegalLottoCountException() {
        super(MESSAGE);
    }

    public IllegalLottoCountException(String message) {
        super(MESSAGE + "입력값: " + message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
