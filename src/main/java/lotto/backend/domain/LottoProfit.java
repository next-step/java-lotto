package lotto.backend.domain;

public class LottoProfit {

    private final double value;

    public LottoProfit(double value) {
        this.value = value;
    }

    public static LottoProfit of(double prizeAmount, int orderAmount) {
        return new LottoProfit(prizeAmount / orderAmount);
    }

    public double getValue() {
        return value;
    }
}
