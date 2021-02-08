package lotto.wrapper;

import lotto.domain.Constants;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public static Money subManual(Money amount, Count lottosManual) {
        int amountManual = amount.getMoney() - lottosManual.getCount() * Constants.LOTTO_PRICE.getMoney();
        return new Money(amountManual);
    }

    public int getMoney() {
        return money;
    }
}
