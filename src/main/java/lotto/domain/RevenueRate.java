package lotto.domain;

import java.util.Objects;

public class RevenueRate {
    private static final int DEFAULT_PERCENT = 1;
    private final double revenue;

    public RevenueRate(int revenue,
                       BuyingAmount buyingAmount) {
        double rate = buyingAmount.divide(revenue);
        this.revenue = Math.floor(rate * 100) / 100;
    }

    public RevenueRate(double revenue) {
        this.revenue = revenue;
    }

    public boolean isBenefit() {
        return DEFAULT_PERCENT < this.revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueRate revenueRate1 = (RevenueRate) o;
        return Double.compare(revenueRate1.revenue, revenue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    @Override
    public String toString() {
        return String.valueOf(revenue);
    }
}
