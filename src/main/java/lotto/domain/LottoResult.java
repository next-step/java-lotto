package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final static long LOTTO_PRICE = 1000;
    private final static double BENEFIT_POINT = 1.0;

    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public long numberOfFirstRank() {
        return ranks.stream()
            .filter(Rank::isFirst)
            .count();
    }

    public long numberOfSecondRank() {
        return ranks.stream()
            .filter(Rank::isSecond)
            .count();
    }

    public long numberOfThirdRank() {
        return ranks.stream()
            .filter(Rank::isThird)
            .count();
    }

    public long numberOfFourthRank() {
        return ranks.stream()
            .filter(Rank::isFourth)
            .count();
    }

    public long numberOfFifthRank() {
        return ranks.stream()
            .filter(Rank::isFifth)
            .count();
    }

    public double calculateProfitRate() {
        BigDecimal profit = Rank.sumPrize(ranks);
        BigDecimal principal = BigDecimal.valueOf(ranks.size() * LOTTO_PRICE);
        BigDecimal profitRate = profit.divide(principal, 2, RoundingMode.DOWN);
        return profitRate.doubleValue();
    }

    public boolean hasBenefit() {
        return calculateProfitRate() >= BENEFIT_POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
