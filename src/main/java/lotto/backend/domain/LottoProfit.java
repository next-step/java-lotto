package lotto.backend.domain;

public class LottoProfit {

    private final double value;

    public LottoProfit(double value) {
        this.value = value;
    }

    public static LottoProfit of(Money prizeAmount, Money orderAmount) {
        return new LottoProfit(prizeAmount.calculateRatio(orderAmount));
    }

    public double getValue() {
        return value;
    }
}
