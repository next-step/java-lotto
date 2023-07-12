package lotto.domain;

import java.util.Objects;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private final long value;

    public Money(long money) {
        validateMoney(money);
        this.value = money;
    }

    private void validateMoney(long value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
    }

    public long countLotto() {
        return this.value / LOTTO_PRICE;
    }

    public double profitRate(Money profit) {
        return profit.divide(this.countLotto() * LOTTO_PRICE);
    }

    private double divide(long denominator) {
        return (double) value / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return value == money1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + value +
                '}';
    }
}
