package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class Number implements Operator, Comparator {
    private final BigDecimal value;

    private Number(String value) {
        this(new BigDecimal(value));
    }

    private Number(BigDecimal value) {
        this.value = value;
    }

    public static Number of() {
        return new Number(BigDecimal.ZERO);
    }

    public static Number of(String value) {
        return new Number(value);
    }

    public static Number of(BigDecimal value) {
        return new Number(value);
    }

    public static Number of(long value) {
        return of(String.valueOf(value));
    }

    public static Number of(double value) {
        return of(String.valueOf(value));
    }

    private boolean isZero(Number left, Number right) {
        return left.isZero() || right.isZero();
    }

    private BinaryOperator<Number> calculator(BinaryOperator<Number> operator) {
        return (left, right) -> {
            if (isZero(left, right)) {
                return Number.of();
            }

            return operator.apply(left, right);
        };
    }

    public boolean isZero() {
        return this.value.equals(BigDecimal.ZERO);
    }

    public long longValue() {
        return this.value.longValue();
    }

    public double doubleValue() {
        return this.value.doubleValue();
    }

    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(this.doubleValue(), number.doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value.toPlainString();
    }

    @Override
    public Number add(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().subtract(r.getValue())))
                .apply(this, right);
    }

    @Override
    public Number subtract(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().subtract(r.getValue())))
                .apply(this, right);
    }

    @Override
    public Number multiply(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().multiply(r.getValue())))
                .apply(this, right);
    }

    @Override
    public Number divide(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().divide(r.getValue(), 2, RoundingMode.HALF_EVEN)))
                .apply(this, right);
    }

    @Override
    public Number min(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().min(r.getValue())))
                .apply(this, right);
    }

    @Override
    public Number max(Number right) {
        return calculator((l, r) -> Number.of(l.getValue().max(r.getValue())))
                .apply(this, right);
    }
}
