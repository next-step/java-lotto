package lotto.domain;

import lotto.domain.exception.LackOfMoneyException;
import lotto.domain.exception.MoneyLowException;

import java.util.Objects;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new MoneyLowException();
        }
        this.money = money;
    }

    public Money spendMoneyToBuyLotto(int numberToBuy) {
        if (money < LOTTO_PRICE) {
            throw new LackOfMoneyException();
        }
        if (money < numberToBuy * LOTTO_PRICE) {
            throw new LackOfMoneyException();
        }

        return new Money(money - numberToBuy * LOTTO_PRICE);
    }

    public int getNumberOfLottoAvailableForPurchases() {
        return money / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
