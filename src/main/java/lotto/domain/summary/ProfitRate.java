package lotto.domain.summary;

import lotto.constants.Winning;

import java.util.Map;
import java.util.Objects;

public class ProfitRate {
    private final float profitRate;

    private ProfitRate(WinningSummary winningSummary, Long purchasePrice) {
        this.profitRate = profitRate(winningSummary.winnings(), purchasePrice);
    }

    public static ProfitRate of(WinningSummary winningSummary, Long purchasePrice) {
        return new ProfitRate(winningSummary, purchasePrice);
    }

    private float profitRate(Map<Winning, Long> winnings, long purchasePrice) {
        return (float) prizeTotal(winnings) / (float) purchasePrice;
    }

    private long prizeTotal(Map<Winning, Long> winnings) {
        return winnings.entrySet().stream()
                .mapToLong(this::prizeTotalByWinning)
                .sum();
    }

    private long prizeTotalByWinning(Map.Entry<Winning, Long> winning) {
        return winning.getKey().prize() * winning.getValue();
    }

    public float value() {
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitRate that = (ProfitRate) o;
        return Float.compare(profitRate, that.profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}
