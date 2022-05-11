package step2.domain;

import java.util.Objects;

public class ReturnRate {

    private static final double PROFIT_THRESHOLD = 1.0;

    private final double value;

    public ReturnRate(int sumOfPrizeMoney, int purchaseAmount) {
        this(sumOfPrizeMoney / (double) purchaseAmount);
    }

    public ReturnRate(double value) {
        this.value = value;
    }

    public boolean isProfitable() {
        return PROFIT_THRESHOLD < this.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnRate that = (ReturnRate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
