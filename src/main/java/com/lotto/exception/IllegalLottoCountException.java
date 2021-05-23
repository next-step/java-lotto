package com.lotto.exception;

public class IllegalLottoCountException extends RuntimeException {
    private static final String MESSAGE = "담청 번호는 6개여야만 합니다.";

    public IllegalLottoCountException() {
        super(MESSAGE);
    }

    public IllegalLottoCountException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
