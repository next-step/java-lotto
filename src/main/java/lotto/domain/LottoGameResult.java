package lotto.domain;

import java.util.Map;

public class LottoGameResult {

    private static final double TWO_DECIMAL_PLACES = 100.0;
    private final Ranks ranks;
    private final PurchaseAmount purchaseAmount;

    public LottoGameResult(Ranks ranks, PurchaseAmount purchaseAmount) {
        this.ranks = ranks;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks.convertToMap();
    }

    public double getRateOfReturn() {
        double rate = purchaseAmount.getRate(ranks.getAllPrizeMoney());
        return Math.floor(rate * TWO_DECIMAL_PLACES) / TWO_DECIMAL_PLACES;
    }

}
