package lotto.domain;

import lotto.exception.MinimumAmountException;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    private Money(int money) {
        validateMinuminMoney(money);
        this.money = money;
    }

    private void validateMinuminMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new MinimumAmountException(money);
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }
}
