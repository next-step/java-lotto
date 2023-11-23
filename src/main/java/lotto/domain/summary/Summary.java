package lotto.domain.summary;

import lotto.constants.Winning;

import java.util.Map;
import java.util.Objects;

public class Summary {
    private final WinningSummary winningSummary;
    private final ProfitRate profitRate;

    private Summary(WinningSummary winningSummary, Long purchasePrice) {
        this.winningSummary = winningSummary;
        this.profitRate = ProfitRate.of(winningSummary, purchasePrice);
    }

    public static Summary of(WinningSummary winningSummary, Long purchasePrice) {
        return new Summary(winningSummary, purchasePrice);
    }

    public Map<Winning, Long> winnings() {
        return winningSummary.winnings();
    }

    public float profitRate() {
        return profitRate.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(winningSummary, summary.winningSummary) && Objects.equals(profitRate, summary.profitRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningSummary, profitRate);
    }
}
