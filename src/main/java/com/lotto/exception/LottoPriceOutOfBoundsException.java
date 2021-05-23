package com.lotto.exception;

import com.lotto.domain.Lotto;

public class LottoPriceOutOfBoundsException extends RuntimeException {
    private static final String MESSAGE = "로또 구매 가격은 로또 가격인 " + Lotto.UNIT_PRICE + "보다 커야합니다. 입력받은 가격:";

    public LottoPriceOutOfBoundsException(int wrongPrice) {
        super(MESSAGE + wrongPrice);
    }

    public LottoPriceOutOfBoundsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
