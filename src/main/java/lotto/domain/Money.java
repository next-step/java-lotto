package lotto.domain;

import lotto.exception.InputError;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(final int money) {
        if (money < 0) {
            throw new InputError("금액은 0 이상의 숫자여야 합니다.");
        }
        this.money = money;
    }

    public int divideBy(Money money) {
        return this.value() / money.value();
    }

    public int value() {
        return money;
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
