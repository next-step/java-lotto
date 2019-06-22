package com.jaeyeonling.lotto.exception;

public class LowMoneyException extends ArithmeticException {

    private static final String ERROR_MESSAGE = "%f 원이 부족하여 구매할 수 없습니다. (잔고: %f, 금액: %f)";

    public LowMoneyException(final double balance,
                             final double price) {
        super(String.format(ERROR_MESSAGE, price - balance, balance, price));
    }
}
