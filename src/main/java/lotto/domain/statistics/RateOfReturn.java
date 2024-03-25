package lotto.domain.statistics;

/**
 * 수익률
 */
public class RateOfReturn {
    private final double value;

    public RateOfReturn(double value) {
        this.value = value;
    }

    public double value() {
        return this.value;
    }

    public boolean lessThan(double target) {
        return this.value < target;
    }

    public boolean equals(double target) {
        return this.value == target;
    }

    public boolean greaterThan(double target) {
        return this.value > target;
    }
}
