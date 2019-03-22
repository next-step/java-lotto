package lotto.domain;

public class LottoResult {
    private final Purchase purchase;
    private final int totalPrize;

    public LottoResult(Purchase purchase, int totalPrize) {
        this.purchase = purchase;
        this.totalPrize = totalPrize;
    }

    public double earningsRate() {
        return purchase.earningsRate(totalPrize);
    }
}
