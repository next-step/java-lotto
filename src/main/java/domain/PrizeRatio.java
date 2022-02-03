package domain;

import java.math.BigDecimal;
import java.util.Map;

public class PrizeRatio {
    private BigDecimal totalPrize;

    public PrizeRatio() {
        this.totalPrize = BigDecimal.ZERO;
    }

    public BigDecimal calculateLottoRatio(int purchasePrice, Map<Rank, Integer> matchCount) {
        calculateLottoTotalPrize(matchCount);
        return totalPrize.divide(new BigDecimal(purchasePrice), 2, BigDecimal.ROUND_HALF_UP);
    }

    private void calculateLottoTotalPrize(Map<Rank, Integer> matchCount) {
        for (Rank rank : Rank.values()) {
            int prize = rank.getPrize();
            int count = matchCount.getOrDefault(rank, 0);
            totalPrize = totalPrize.add(new BigDecimal(prize * count));
        }
    }
}
