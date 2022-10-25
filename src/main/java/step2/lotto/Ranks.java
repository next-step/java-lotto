package step2.lotto;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public Map<Rank, Long> statisticsRanks() {
        Map<Rank, Long> ranks = countedWinningRanks();
        countNotWinningRanks(ranks);
        return Map.copyOf(ranks);
    }

    private Map<Rank, Long> countedWinningRanks() {
        return rankingAggregation.stream()
                .filter(Rank::isNotNothing)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private void countNotWinningRanks(Map<Rank, Long> ranks) {
        EnumSet.allOf(Rank.class)
                .stream()
                .filter(Rank::isNotNothing)
                .filter(rank -> !ranks.containsKey(rank))
                .forEach(rank -> ranks.put(rank, 0L));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks ranks = (Ranks) o;
        return Objects.equals(rankingAggregation, ranks.rankingAggregation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankingAggregation);
    }
}
