package lotto.domain;

import java.util.Objects;

public class ProfitRate {
    private static final double STANDARD = 1;
    private final double profitRate;

    public ProfitRate(TotalPrize totalPrize, PurchaseAmount purchaeAmount) {
        this((double) totalPrize.totalPrize() / purchaeAmount.purchaseAmount());
    }

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public double profitRate() {
        return profitRate;
    }

    public boolean isPositive() {
        return profitRate >= STANDARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitRate that = (ProfitRate) o;
        return Double.compare(that.profitRate, profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}
