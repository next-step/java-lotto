package lotto.model.domain;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(long totalPrize, double spentMoney) {
        this.profitRate = totalPrize / spentMoney;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
