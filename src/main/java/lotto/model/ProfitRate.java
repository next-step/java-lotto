package lotto.model;

public final class ProfitRate {

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
        if (spentMoney < 0.0) {
            throw new IllegalArgumentException("지불한 돈은 0 이상입니다.");
        }
    }

    private static void validateTotalPrize(long totalPrize) {
        if (totalPrize < 0L) {
            throw new IllegalArgumentException("총 상금은 0 이상입니다.");
        }
    }

    public double getProfitRate() {
        return profitRate;
    }
}
