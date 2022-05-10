package lotto.domain;

import java.util.List;

public class RankResults {

    private final List<RankResult> rankResults;

    public RankResults(List<RankResult> rankResults) {
        this.rankResults = rankResults;
    }

    public List<RankResult> getRankResults() {
        return rankResults;
    }

    public double getProfitRatio(Money money) {
        Long totalPrizeInteger = getTotalPrize();
        Money totalPrize = new Money(totalPrizeInteger);
        return totalPrize.divide(money);
    }

    private Long getTotalPrize() {
        return rankResults
                .stream()
                .map(RankResult::getPrizePerRank)
                .reduce(0L, Long::sum);
    }
}
