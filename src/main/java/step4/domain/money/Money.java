package step4.domain.money;

import step4.exception.InputNegativeAmountException;

public final class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        validate(money);
        this.money = money;
    }

    private final void validate(int money) {
        if (money < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

}
