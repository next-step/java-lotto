package lotto.model;

import java.util.Collections;
import java.util.List;

public class RankResults {

    private final List<RankResult> rankResults;

    public RankResults(List<RankResult> rankResults) {
        this.rankResults = Collections.unmodifiableList(rankResults);
    }

    public double calculateProfitRatio(Money principal) {
        Money sumOfMoney = sum();
        return sumOfMoney.divide(principal);
    }

    public List<RankResult> getRankResults() {
        return rankResults;
    }

    private Money sum() {
        Money sumOfWinnings = new Money();
        for (RankResult rankResult : rankResults) {
            long amount = rankResult.getRank().getAmount();
            int count = rankResult.getCount();
            sumOfWinnings = sumOfWinnings.add(new Money(amount * count));
        }
        return sumOfWinnings;
    }

}
