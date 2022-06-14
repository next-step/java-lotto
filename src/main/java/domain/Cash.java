package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Cash {
    private final BigDecimal cashAmount;

    public Cash(int cashAmount) {
        this.cashAmount = BigDecimal.valueOf(cashAmount);
    }

    public Cash(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Cash add(Cash cash) {
        return new Cash(cashAmount.add(cash.cashAmount));
    }

    public Cash divide(Cash cash) {
        return new Cash(cashAmount.divide(cash.cashAmount, RoundingMode.HALF_UP));
    }

    public Cash multiply(int count) {
        return new Cash(cashAmount.multiply(BigDecimal.valueOf(count)));
    }

    public boolean isLessThan(Cash comparedCash) {
        return cashAmount.compareTo(comparedCash.cashAmount) < 0;
    }

    public boolean isMoreThan(Cash comparedCash) {
        return cashAmount.compareTo(comparedCash.cashAmount) > 0;
    }

    public boolean isMultipleOf(Cash cash) {
        return cashAmount.remainder(cash.cashAmount).equals(BigDecimal.ZERO);
    }

    public BigDecimal toBigDecimal() {
        return cashAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return cashAmount.equals(cash.cashAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashAmount);
    }

    @Override
    public String toString() {
        return String.valueOf(cashAmount);
    }
}
