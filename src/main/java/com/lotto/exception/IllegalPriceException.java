package com.lotto.exception;

public class IllegalPriceException extends RuntimeException {
    private static final String MESSAGE = "잘못된 가격 입니다. 입력받은 가격:";

    public IllegalPriceException(String wrongPrice) {
        super(MESSAGE + wrongPrice);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
