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

    // todo test
    public double getProfitRatio(int money) {
        Integer totalPrize = getTotalPrize();
        return (double) totalPrize / money;
    }

    private Integer getTotalPrize() {
        return rankResults
                .stream()
                .map(RankResult::getPrizePerRank)
                .reduce(0, Integer::sum);
    }
}
