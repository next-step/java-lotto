package lotto.domain;

import java.util.Objects;

public class Money {

    private final long money;
    private final static String MONEY_NEGATIVE_EXCEPTION = "Money는 음수가 될 수 없습니다.";

    public Money(final long money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_EXCEPTION);
        }
        this.money = money;
    }

    public Double divide(final Money money) {
        return (double) this.money / money.money;
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

    @Override
    public String toString() {
        return String.valueOf(money);
    }

}
