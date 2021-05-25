package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int MONEY_PER_LOTTO = 1_000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int countOfBuyingLotto() {
        return money / MONEY_PER_LOTTO;
    }

    public Money buyManual(int countOfLotto) {
        return new Money(money - countOfLotto * MONEY_PER_LOTTO);
    }

    public Money sum(Money money) {
        return new Money(this.money + money.money);
    }

    public double profitRate(Money prize) {
        return (prize.money * 100) / money;
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
