package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;

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

    public static Number of(BigDecimal value) {
        return new Number(value);
    }

    public static Number of(long value) {
        return of(String.valueOf(value));
    }

    public static Number of(double value) {
        return of(String.valueOf(value));
    }

    public boolean isZero() {
        return this.value.equals(BigDecimal.ZERO);
    }

    public Number incrementAndGet() {
        return new Number(this.value.add(BigDecimal.ONE));
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
}
