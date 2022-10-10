package lotto.domain;

import java.util.Objects;

public class Money {

    private int money;
    private static String MONEY_NEGATIVE_EXCEPTION = "Money는 음수가 될 수 없습니다.";

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_EXCEPTION);
        }
        this.money = money;
    }

    public int divide(int number) {
        return this.money / number;
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
