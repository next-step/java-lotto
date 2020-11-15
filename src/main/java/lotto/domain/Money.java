package lotto.domain;

import lotto.exception.BadMoneyException;

import java.util.Objects;

// TODO: ProfitMoney 와 PurchaseMoney 분리하
public class Money {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public static void validateMoney(int money) {
        if (money <= 0) {
            throw BadMoneyException.getInstance();
        }

    }

    public int getNumOfLottos() {
        return money / LOTTO_PRICE;
    }

    public double divide(Money divider) {
        return money / divider.money;
    }

    @Override
    public String toString() {
        return Integer.toString(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
