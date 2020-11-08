package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;

public class Money {
    private static final int MINIMUM_AMOUNT = 1;
    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        validateAmount(amount);
        return new Money(amount);
    }

    private static void validateAmount(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new InvalidMoneyException();
        }
    }

}
