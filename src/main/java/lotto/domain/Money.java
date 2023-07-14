package lotto.domain;

import java.util.Objects;

public class Money {

    private static final long MIN_PRICE = 0L;
    private static final long ZERO_DIVISION = 0L;

    private final long value;

    public Money(long money) {
        validateMoney(money);
        this.value = money;
    }

    public long getValue() {
        return value;
    }

    private void validateMoney(long value) {
        if (value < MIN_PRICE) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
        }
    }

    public Count count(Money denominator) {
        validateAtLeastOne(this.value, denominator.value);
        validateNotZeroDominator(denominator.value);
        return new Count(this.value / denominator.value);
    }

    private void validateAtLeastOne(long value, long price) {
        if (value < price) {
            throw new IllegalStateException("현재 잔액으로는 구매할 수 없습니다.");
        }
    }

    private static void validateNotZeroDominator(long denominator) {
        if (denominator == ZERO_DIVISION) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
    }

    public static Profit calculateProfitRate(Money profit, Money principal) {
        return new Profit(profit.value, principal.value);
    }

    public Money multiply(long count) {
        return new Money(value * count);
    }

    public static Money sum(Money money1, Money money2) {
        return new Money(money1.value + money2.value);
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
