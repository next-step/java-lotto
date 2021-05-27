package com.lotto.exception;

public class LottoPriceNumberFormatException extends RuntimeException {
    private static final String MESSAGE = "잘못된 가격 입니다. 입력받은 가격:";

    public LottoPriceNumberFormatException(String wrongPrice) {
        super(MESSAGE + wrongPrice);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
