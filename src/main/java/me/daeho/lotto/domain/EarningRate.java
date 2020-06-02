package me.daeho.lotto.domain;

import java.util.Objects;

public class EarningRate {
    private final double value;

    private EarningRate(double value) {
        this.value = value;
    }

    public static EarningRate of(double value) {
        return new EarningRate(value);
    }

    public double value() {
        return value;
    }

    public boolean isProfit() {
        return value >= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarningRate that = (EarningRate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
