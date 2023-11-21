package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Amount {
    private Long amount;

    public Amount() {
        this.amount = 0l;
    }

    public Amount(int amount) {
        this.amount = Long.valueOf(amount);
    }

    public Amount(Long amount) {
        this.amount = amount;
    }

    public void add(Long value) {
        this.amount += value;
    }

    public BigDecimal divide(Long amount, int digit) {
        BigDecimal numerator = new BigDecimal(this.amount);
        BigDecimal denominator = new BigDecimal(amount);
        return numerator.divide(denominator, digit, RoundingMode.HALF_UP);
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
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
