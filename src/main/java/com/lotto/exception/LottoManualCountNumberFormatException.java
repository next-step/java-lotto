package com.lotto.exception;

public class LottoManualCountNumberFormatException extends RuntimeException {
    private static final String MESSAGE = "수동 구매할 로또 수는 숫자 포맷이어야 합니다.";

    public LottoManualCountNumberFormatException() {
        super(MESSAGE);
    }

    public LottoManualCountNumberFormatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
