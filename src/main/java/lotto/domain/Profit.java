package lotto.domain;

public class Profit {

    private final double profitRate;

    public Profit(Money principal, Money profit) {
        this.profitRate = principal.profitRate(profit);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
