package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class LottoResults {

    private final Map<Rank, Integer> matchingStats;

    public LottoResults(Map<Rank, Integer> matchingStats) {
        this.matchingStats = Collections.unmodifiableMap(matchingStats);
    }

    public Money totalReward() {
        int totalReward = matchingStats.keySet().stream()
                .mapToInt(this::rankTotalReward)
                .sum();
        return new Money(totalReward);
    }

    private int rankTotalReward(Rank rank) {
        int count = rankTotalCount(rank);
        return rank.totalReward(count);
    }

    private int rankTotalCount(Rank rank) {
        return matchingStats.get(rank);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Rank.values()).forEach(rank ->
                sb.append(rank).append(String.format("- %d개\n", matchingStats.getOrDefault(rank, 0)))
        );
        return sb.toString();
    }
}
