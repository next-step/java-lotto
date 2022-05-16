package lotto.domain;

import java.util.List;

public class RankResults {

    private final List<RankResult> rankResultList;

    public RankResults(List<RankResult> rankResults) {
        this.rankResultList = rankResults;
    }

    public List<RankResult> getRankResultList() {
        return rankResultList;
    }

    public double getProfitRatio(Money money) {
        Long totalPrizeInteger = getTotalPrize();
        Money totalPrize = new Money(totalPrizeInteger);
        return totalPrize.divide(money);
    }

    private Long getTotalPrize() {
        return rankResultList
                .stream()
                .map(RankResult::getPrizePerRank)
                .reduce(0L, Long::sum);
    }
}
