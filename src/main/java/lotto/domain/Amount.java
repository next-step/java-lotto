package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Amount implements Comparable<Amount> {
    private Long amount;

    public static Amount of(PositiveNumber value) {
        return new Amount(Long.valueOf(value.getPositiveNumber()));
    }

    public static Amount of(int amount) {
        return new Amount(Long.valueOf(amount));
    }

    public static Amount of(Long amount) {
        return new Amount(amount);
    }

    private Amount(Long amount) {
        this.amount = amount;
    }

    public void add(Long value) {
        this.amount += value;
    }

    public int divideToInt(int value) {
        return (int) (amount / value);
    }

    public BigDecimal divideToBigDecimal(Long amount, int digit) {
        BigDecimal numerator = new BigDecimal(this.amount);
        BigDecimal denominator = new BigDecimal(amount);
        return numerator.divide(denominator, digit, RoundingMode.HALF_UP);
    }

    public Amount minus(Amount amount) {
        return new Amount(this.amount - amount.amount());
    }

    public Long amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount that = (Amount) o;
        return amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public int compareTo(Amount other) {
        // 직접 필드 값을 비교하여 대소를 판단합니다.
        return Long.compare(this.amount, other.amount);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
