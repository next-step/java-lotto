package lotto.domain;

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

    public double rateOfReturn(Cash inputCash) {
        return ((double) earned()) / inputCash.value();
    }

    private long earned() {
        return ranks.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().winnings() * entry.getValue().value())
                .sum();
    }

}
