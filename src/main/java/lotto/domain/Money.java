package lotto.domain;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public boolean lt(int number) {
        return money < number;
    }

    public boolean isNotDivisibleBy(int number) {
        return money % number != 0;
    }

    public int divideBy(int number) {
        return money / number;
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
