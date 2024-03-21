package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Count> ranks = new HashMap<>();

    public WinningStatistics(LottoMatchCounts matchCounts) {
        this(matchCounts.ranks());
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
}
