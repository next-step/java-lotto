package lotto.domain;

import java.util.Collections;
import java.util.Map;

public final class WinningCount {

    private static final long DEFAULT_COUNT = 0L;

    private final Map<Rank, Long> counts;

    public WinningCount(Map<Rank, Long> counts) {
        this.counts = Collections.unmodifiableMap(counts);
    }

    public long getMatchCount(final Rank rank) {
        return counts.getOrDefault(rank, DEFAULT_COUNT);
    }

    public long calculatePrize() {
        long totalPrize = 0L;

        for (Rank rank : counts.keySet()) {
            long winningCount = counts.get(rank);
            long prize = rank.getPrize();
            totalPrize += (prize * winningCount);
        }

        return totalPrize;
    }
}
