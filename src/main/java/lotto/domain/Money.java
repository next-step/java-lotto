package lotto.domain;

import java.util.Objects;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private static final long MIN_PRICE = 0L;
    private static final long ZERO_DIVISION = 0L;
    private final long value;

    public Money(long money) {
        validateMoney(money);
        this.value = money;
    }

    private void validateMoney(long value) {
        if (value < MIN_PRICE) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
        }
    }

    public long countLotto() {
        validateLeastOneLotto();
        validateNotZeroDominator(LOTTO_PRICE);
        return this.value / LOTTO_PRICE;
    }

    private void validateLeastOneLotto() {
        if (value < LOTTO_PRICE) {
            throw new IllegalStateException("로또를 구매할 수 없습니다.");
        }
    }

    public double profitRate(Money profit) {
        return profit.divide(this.countLotto() * LOTTO_PRICE);
    }

    private double divide(long denominator) {
        validateNotZeroDominator(denominator);
        return (double) value / denominator;
    }

    private void validateNotZeroDominator(long denominator) {
        if (denominator == ZERO_DIVISION) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
    }

    public boolean isZero() {
        return value == ZERO_DIVISION;
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
