package lotto.domain;

import common.InputValidator;

public class Amount {

    private static final int PRICE_PER_TICKET = 1000;
    private final int value;

    public Amount(int value) {
        InputValidator.validatePurchaseAmount(value);
        this.value = value;
    }

    public int calculateLottoCount(int amount) {
        return amount / PRICE_PER_TICKET;
    }

    public int getValue() {
        return value;
    }
}
