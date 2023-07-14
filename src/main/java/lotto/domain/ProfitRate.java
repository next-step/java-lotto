package lotto.domain;

public class ProfitRate {
    private final int profit;
    private final int payment;

    public ProfitRate(int profit, int payment) {
        this.profit = profit;
        this.payment = payment;
    }

    public float calculateRate() {
        return profit / payment;
    }
}
