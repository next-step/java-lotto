package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Cash {
    private final int cashAmount;

    public Cash(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public int divide(Cash cash) {
        return cashAmount / cash.cashAmount;
    }

    public Cash multiply(int count) {
        return new Cash(cashAmount * count);
    }

    public boolean isLessThan(Cash comparedCash) {
        return cashAmount < comparedCash.cashAmount;
    }

    public boolean isMultipleOf(Cash cash) {
        return cashAmount % cash.cashAmount == 0;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(cashAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return cashAmount == cash.cashAmount;
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
