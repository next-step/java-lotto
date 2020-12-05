package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningCount {

    private final Map<Integer, Integer> counts;

    public WinningCount() {
        this.counts = new HashMap<>();
    }

    public void increaseCount(int matchCount) {
        counts.putIfAbsent(matchCount, 0);

        int value = counts.get(matchCount);

        counts.put(matchCount, value + 1);
    }

    public int getMatchCount(int matchCount) {
        return counts.getOrDefault(matchCount, 0);
    }

    public int calculatePrize() {
        int totalPrize = 0;

        for (int matchCount : counts.keySet()) {
            int winningCount = counts.get(matchCount);
            int prize = Rank.getRankingPrize(matchCount);
            totalPrize += (prize * winningCount);
        }

        return totalPrize;
    }

    public double calculateEarnRate(int paid) {
        int totalPrize = calculatePrize();
        return (double) totalPrize / paid;
    }
}
