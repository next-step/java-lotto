package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class Number {
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

    public static Number of(long value) {
        return of(String.valueOf(value));
    }

    public static Number of(double value) {
        return of(String.valueOf(value));
    }

    public static Number min(Number left, Number right) {
        return left.calculator(right, (l, r) -> new Number(l.value.min(r.value)));
    }

    public static Number max(Number left, Number right) {
        return left.calculator(right, (l, r) -> new Number(l.value.max(r.value)));
    }

    private Number calculator(Number right, BinaryOperator<Number> calculator) {
        if (this.isZero() || right.isZero()) {
            return Number.of();
        }

        return calculator.apply(this, right);
    }

    public boolean isZero() {
        return this.value.equals(BigDecimal.ZERO);
    }

    public Number add(Number right) {
        return calculator(right, (l, r) -> new Number(l.value.add(r.value)));
    }

    public Number subtract(Number right) {
        return calculator(right, (l, r) -> new Number(l.value.subtract(r.value)));
    }

    public Number multiple(Number right) {
        return calculator(right, (l, r) -> new Number(l.value.multiply(r.value)));
    }

    public Number divide(Number right) {
        return calculator(right, (l, r) -> new Number(l.value.divide(r.value, 2, RoundingMode.HALF_EVEN)));
    }

    public long longValue() {
        return this.value.longValue();
    }

    public double doubleValue() {
        return this.value.doubleValue();
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
}
