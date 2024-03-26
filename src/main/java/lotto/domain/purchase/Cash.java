package lotto.domain.purchase;

import lotto.domain.statistics.RateOfReturn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Cash implements Comparable<Cash> {
    private final BigDecimal value;

    public Cash(long cash) {
        this(BigDecimal.valueOf(cash));
    }

    public Cash() {
        this(BigDecimal.ZERO);
    }

    public Cash(BigDecimal cash) {
        assertCashPositive(cash);
        this.value = cash;
    }

    public static Cash sum(Cash first, Cash second) {
        return first.add(second);
    }

    public BigDecimal value() {
        return this.value;
    }

    public Amount buyableAmount(Cash price) {
        assertPriceGreaterThanZero(price);

        return new Amount(value.divideToIntegralValue(price.value()));
    }

    public RateOfReturn rateOfReturn(Cash earned) {
        return new RateOfReturn(earned.value().divide(value, MathContext.DECIMAL32).doubleValue());
    }

    public boolean equalsZero() {
        return value.equals(BigDecimal.ZERO);
    }

    public boolean smallerThan(Cash target) {
        return value.compareTo(target.value()) < 0;
    }

    public boolean greaterThanZero() {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

    public Cash add(Cash other) {
        return new Cash(this.value.add(other.value()));
    }

    public Cash multiply(int amount) {
        return multiply(new Amount(amount));
    }

    public Cash multiply(Amount amount) {
        return new Cash(
                value.multiply(BigDecimal.valueOf(amount.value())));
    }

    public Cash subtract(Cash target) {
        return new Cash(value.subtract(target.value()));
    }

    private void assertCashPositive(BigDecimal cash) {
        if (cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("현금은 마이너스 통장이 아닙니다.");
        }
    }

    private void assertPriceGreaterThanZero(Cash price) {
        if (price.equalsZero()) {
            throw new IllegalArgumentException("공짜는 없는 세상입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return Objects.equals(value, cash.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Cash other) {
        return this.value.compareTo(other.value());
    }
}
