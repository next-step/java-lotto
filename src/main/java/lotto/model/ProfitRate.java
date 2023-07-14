package lotto.model;

import java.util.Objects;

public final class ProfitRate {

    public static final double MIN_SPENT_MONEY = 1000.0;
    public static final long MIN_TOTAL_PRIZE = 0L;

    private final double profitRate;

    public ProfitRate(final long totalPrize, final double spentMoney) {
        validate(totalPrize, spentMoney);
        this.profitRate = totalPrize / spentMoney;
    }

    private void validate(long totalPrize, double spentMoney) {
        validateTotalPrize(totalPrize);
        validateSpentMoney(spentMoney);
    }

    private static void validateSpentMoney(double spentMoney) {
        if (spentMoney < MIN_SPENT_MONEY) {
            throw new IllegalArgumentException("지불한 돈은 " + MIN_SPENT_MONEY + " 이상입니다.");
        }
    }

    private static void validateTotalPrize(long totalPrize) {
        if (totalPrize < MIN_TOTAL_PRIZE) {
            throw new IllegalArgumentException("총 상금은 " + MIN_TOTAL_PRIZE + " 이상입니다.");
        }
    }

    public double getProfitRate() {
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfitRate that = (ProfitRate) o;
        return Double.compare(that.profitRate, profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}
