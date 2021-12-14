package lotto.domain;

import java.util.Objects;

public class Rate {
    private double value;

    public Rate(double value) {
        this.value = value;
    }

    public Rate rate(double dividend, double divisor) {
        if(dividend == 0) {
            return this;
        }
        return new Rate(Math.floor((dividend / divisor) * 100) / 100.0);
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rate)) return false;
        Rate rate = (Rate) o;
        return Double.compare(rate.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
