package lotto.domain;

public final class ProfitRate {
    private final float profitRate;

    public ProfitRate(final ResultRecord resultRecord, final Payment payment) {
        int profit = resultRecord.calculateProfit();
        this.profitRate = payment.divide(profit);
    }

    public float getProfitRate() {
        return profitRate;
    }
}
