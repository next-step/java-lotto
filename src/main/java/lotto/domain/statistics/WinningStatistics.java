package lotto.domain.statistics;

import lotto.domain.Cash;
import lotto.domain.rank.Rank;
import lotto.domain.rank.Ranks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Count> ranks = new HashMap<>();

    public WinningStatistics(Ranks ranks) {
        this(ranks.values());
    }

    public WinningStatistics(List<Rank> ranks) {
        if (ranks == null || ranks.isEmpty()) {
            return;
        }
        ranks.forEach(this::increaseEachRankCount);
    }

    private void increaseEachRankCount(Rank key) {
        ranks.computeIfAbsent(key, rank -> new Count())
                .increase();
    }

    public Count rankCount(Rank rank) {
        return ranks.getOrDefault(rank, new Count());
    }

    public RateOfReturn rateOfReturn(Cash inputCash) {
        return inputCash.rateOfReturn(earned());
    }

    private Cash earned() {
        return new Cash(
                ranks.entrySet()
                    .stream()
                    .mapToLong(entry -> entry.getKey().winnings() * entry.getValue().value())
                    .sum());
    }

}
