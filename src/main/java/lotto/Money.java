package lotto;

import java.util.Objects;

public class Money {
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public Money plus(Money other) {
        return new Money(money + other.money);
    }

    public Money minus(Money other) {
        int rest = money - other.money;
        if (rest < 0) {
            throw new IllegalArgumentException("Money는 음수가 될 수 없습니다.");
        }
        return new Money(rest);
    }

    public int countBy(Money other) {
        return money / other.money;
    }

    public Money multiplyBy(int count) {
        return new Money(money * count);
    }

    public double earningRate(Money other) {
        return (double) money / (double) other.money;
    }

    public int getMoney() {
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
