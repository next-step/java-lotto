package domain;

import java.math.BigDecimal;

public class RatioCalculator {
    private BigDecimal totalPrize;

    public RatioCalculator() {
        totalPrize = BigDecimal.ZERO;
    }

    public BigDecimal calculateRatio(int purchasePrice, LottoResult lottoResult) {
        calculateTotalPrize(lottoResult);
        return totalPrize.divide(new BigDecimal(purchasePrice), 2, BigDecimal.ROUND_HALF_UP);
    }

    private void calculateTotalPrize(LottoResult lottoResult) {
        for (Rank rank : Rank.values()) {
            int prize = rank.getPrize();
            int count = lottoResult.getRankCount(rank);
            totalPrize = totalPrize.add(new BigDecimal(prize * count));
        }
    }
}
