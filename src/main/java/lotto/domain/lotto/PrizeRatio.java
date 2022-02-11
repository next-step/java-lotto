package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class PrizeRatio {

    private static final int ROUND_SCALE = 2;

    private BigDecimal totalPrize;

    public PrizeRatio() {
        this.totalPrize = BigDecimal.ZERO;
    }

    public BigDecimal calculateRatio(final Amount amount, final Map<Rank, Integer> prizeMap) {
        calculatePrize(prizeMap);
        return totalPrize.divide(new BigDecimal(amount.value()), ROUND_SCALE, RoundingMode.DOWN);
    }

    private void calculatePrize(final Map<Rank, Integer> prizeMap) {
        for (Rank rank: Rank.values()) {
            int prize = rank.getPrize();
            int count = prizeMap.getOrDefault(rank, 0);
            totalPrize = totalPrize.add(new BigDecimal(prize * count));
        }
    }
}
