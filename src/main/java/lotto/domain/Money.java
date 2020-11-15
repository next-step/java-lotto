package lotto.domain;

import lotto.exception.BadDividerException;
import lotto.exception.BadMoneyException;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw BadMoneyException.getInstance();
        }

    }

    public double divide(Money divider) {
        if (divider.money <= 0) {
            throw BadDividerException.getInstance();
        }
        return money / divider.money;
    }

    @Override
    public String toString() {
        return Integer.toString(money);
    }
}
