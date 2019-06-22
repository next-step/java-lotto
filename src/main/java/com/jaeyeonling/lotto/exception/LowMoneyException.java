package com.jaeyeonling.lotto.exception;

public class LowMoneyException extends ArithmeticException {

    private static final String ERROR_MESSAGE = "%d 원이 부족하여 구매할 수 없습니다. (잔고: %d, 금액: %d)";

    public LowMoneyException(final int balance,
                             final int price) {
        super(String.format(ERROR_MESSAGE, price - balance, balance, price));
    }
}
