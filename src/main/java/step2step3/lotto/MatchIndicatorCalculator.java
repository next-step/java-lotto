package step2step3.lotto;

import step2step3.lotto.lottoTicket.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class MatchIndicatorCalculator {

    private final List<Rank> rankingAggregation;

    public MatchIndicatorCalculator(List<Rank> rankingAggregation) {
        this.rankingAggregation = rankingAggregation;
    }

    public Map<Rank, Long> matchIndicators() {
        Map<Rank, Long> ranks = countedWinningRanks();
        countNotWinningRanks(ranks);

        return sortedRanks(ranks);
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

    private TreeMap<Rank, Long> sortedRanks(Map<Rank, Long> ranks) {
        TreeMap<Rank, Long> sortedRanks = new TreeMap<>(Comparator.comparing(Rank::prizeAmount));
        sortedRanks.putAll(ranks);
        return sortedRanks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchIndicatorCalculator that = (MatchIndicatorCalculator) o;
        return Objects.equals(rankingAggregation, that.rankingAggregation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankingAggregation);
    }

}
