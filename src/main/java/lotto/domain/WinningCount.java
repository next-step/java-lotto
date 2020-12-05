package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public final class WinningCount {

    private final Map<Rank, Integer> counts;

    public WinningCount() {
        this.counts = new HashMap<>();
    }

    public void increaseCount(final Rank rank) {
        counts.merge(rank, 1, Integer::sum);
    }

    public int getMatchCount(final Rank rank) {
        return counts.getOrDefault(rank, 0);
    }

    public int calculatePrize() {
        int totalPrize = 0;

        for (Rank rank : counts.keySet()) {
            int winningCount = counts.get(rank);
            int prize = rank.getPrize();
            totalPrize += (prize * winningCount);
        }

        return totalPrize;
    }

    public double calculateEarnRate(int paid) {
        int totalPrize = calculatePrize();
        return (double) totalPrize / paid;
    }
}
