package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Number {

    private BigDecimal value;

    private Number() {
        this.value = BigDecimal.ZERO;
    }

    private Number(long value) {
        this.value = new BigDecimal(value);
    }

    private Number(BigDecimal value) {
        this.value = value;
    }

    public static Number of() {
        return new Number();
    }

    public static Number of(long value) {
        return new Number(value);
    }

    public Number incrementAndGet() {
        this.value = this.value.add(BigDecimal.ONE);
        return this;
    }

    public Number add(Number number) {
        return new Number(this.value.add(number.value));
    }

    public Number multiple(Number number) {
        return new Number(this.value.multiply(number.value));
    }

    public Number divide(Number number) {
        if (this.value.equals(BigDecimal.ZERO) || number.value.equals(BigDecimal.ZERO)) {
            return new Number();
        }
        return new Number(this.value.divide(number.value, 2, RoundingMode.HALF_EVEN));
    }

    public long getLongValue() {
        return this.value.longValue();
    }

    public double getDoubleValue() {
        return this.value.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
