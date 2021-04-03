package step3.domain.money;

import step3.exception.InputNegativeAmountException;

public final class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        validateAmount(money);
        this.money = money;
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

    private final void validateAmount(int amount) {
        if (amount < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

}
