package lotto.domain;

public class Profit {

    private final double profitRate;

    public Profit(Money profit, long lottoCount) {
        this.profitRate = profit.profitRate(lottoCount);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
