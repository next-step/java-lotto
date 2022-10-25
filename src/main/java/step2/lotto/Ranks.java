package step2.lotto;

import java.util.List;

public class Ranks {

    private static final int LOTTO_PRICE = 1000;

    private final List<Rank> rankingAggregation;

    public Ranks(List<Rank> rankingAggregation) {
        this.rankingAggregation = rankingAggregation;
    }

    public double yield() {
        return totalPrizeAmount() / (rankingAggregation.size() * LOTTO_PRICE);
    }

    private double totalPrizeAmount() {
        return rankingAggregation.stream()
                .reduce(0.0, (prizeAmount, rank) -> rank.addedPrizeAmount(prizeAmount), Double::sum);
    }

}
