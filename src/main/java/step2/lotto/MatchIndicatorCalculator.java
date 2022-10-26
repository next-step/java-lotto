package step2.lotto;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchIndicatorCalculator {

    private final List<Rank> rankingAggregation;

    public MatchIndicatorCalculator(List<Rank> rankingAggregation) {
        this.rankingAggregation = rankingAggregation;
    }

    public Map<Rank, Long> matchIndicators() {
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

}
