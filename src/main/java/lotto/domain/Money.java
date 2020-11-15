package lotto.domain;

import lotto.exception.BadMoneyException;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw BadMoneyException.getInstance();
        }

    }

    // TODO: divde 함수 없애기
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
