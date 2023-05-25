package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResults {

    private final Map<Rank, Integer> winningStats;

    LottoResults(Map<Rank, Integer> winningStats) {
        this.winningStats = Collections.unmodifiableMap(winningStats);
    }

    public Money totalReward() {
        int totalReward = winningStats.keySet().stream()
                .mapToInt(this::rankTotalReward)
                .sum();
        return new Money(totalReward);
    }

    private int rankTotalReward(Rank rank) {
        int count = rankTotalCount(rank);
        return rank.totalReward(count);
    }

    private int rankTotalCount(Rank rank) {
        return winningStats.get(rank);
    }

    public Map<Rank, Integer> matchingStats() {
        return new HashMap<>(winningStats);
    }
}
