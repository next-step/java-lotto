package com.lotto.exception;

public class LottoManualCountOutOfBoundsException extends RuntimeException {
    private static final String MESSAGE = "구입금액에 따른 수동 구매수를 벗어났습니다. 최소: 0, 최대: ";

    public LottoManualCountOutOfBoundsException(int wrongNumber) {
        super(MESSAGE + wrongNumber);
    }

    public LottoManualCountOutOfBoundsException(String message) {
        super(message);
    }
}
