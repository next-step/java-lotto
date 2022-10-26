package step2.lotto;

import java.util.List;

public class YieldCalculator {

    private final int individualAmount;

    private final List<Rank> rankingAggregation;

    public YieldCalculator(int individualAmount, List<Rank> rankingAggregation) {
        this.individualAmount = individualAmount;
        this.rankingAggregation = rankingAggregation;
    }

    public double yield() {
        return totalPrizeAmount() / (rankingAggregation.size() * individualAmount);
    }

    private double totalPrizeAmount() {
        return rankingAggregation.stream()
                .reduce(0.0, (prizeAmount, rank) -> rank.addedPrizeAmount(prizeAmount), Double::sum);
    }

}
