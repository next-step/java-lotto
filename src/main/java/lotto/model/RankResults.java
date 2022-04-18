package lotto.model;

import java.util.Collections;
import java.util.List;

public class RankResults {

    private List<RankResult> rankResults;

    private final int purchaseTicketCount;

    public RankResults(List<RankResult> rankResults, int purchaseTicketCount) {
        this.rankResults = Collections.unmodifiableList(rankResults);
        this.purchaseTicketCount = purchaseTicketCount;
    }

    public double calculateProfitRatio() {
        long sumOfMoney = sum();
        return sumOfMoney % purchaseTicketCount;
    }

    public List<RankResult> getRankResults() {
        return rankResults;
    }

    private long sum() {
        long sumOfMoney = 0L;
        for (RankResult rankResult : rankResults) {
            long amount = rankResult.getRank().getAmount();
            int count = rankResult.getCount();
            sumOfMoney += amount * count;
        }

        return sumOfMoney;
    }

}
