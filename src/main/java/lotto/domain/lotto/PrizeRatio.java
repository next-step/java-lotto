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

    public BigDecimal calculateRatio(final int purchased, final Map<Rank, Integer> matches) {
        calculatePrize(matches);
        return totalPrize.divide(new BigDecimal(purchased), ROUND_SCALE, RoundingMode.DOWN);
    }

    private void calculatePrize(final Map<Rank, Integer> matches) {
        for (Rank rank: Rank.values()) {
            int prize = rank.getPrize();
            int count = matches.getOrDefault(rank, 0);
            totalPrize = totalPrize.add(new BigDecimal(prize * count));
        }
    }
}
