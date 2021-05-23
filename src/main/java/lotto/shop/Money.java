package lotto.shop;

import lotto.error.ErrorMessage;

public class Money {
    private final int amount;

    public Money(int amount) {
        checkNegative(amount);
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    private void checkNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_CANNOT_BE_NEGATIVE);
        }
    }
}