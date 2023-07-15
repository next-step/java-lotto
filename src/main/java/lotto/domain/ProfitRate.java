package lotto.domain;

public class ProfitRate {
    private final float profitRate;

    public ProfitRate(ResultRecord resultRecord, Payment payment) {
        int profit = resultRecord.calculateProfit();
        this.profitRate = payment.divide(profit);
    }

    public float getProfitRate() {
        return profitRate;
    }
}
