package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final Map<Integer, Integer> PRIZES = Map.of(
            3, 5_000,
            4, 50_000,
            5, 1_500_000,
            6, 2_000_000_000
    );

    private final Map<Integer, Integer> matchCounts;

    public WinningStatistics(Map<Integer, Integer> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public WinningStatistics(List<Integer> matchCounts) {
        this(toCountMap(matchCounts));
    }

    public WinningStatistics(int... matchCounts) {
        this(Arrays.stream(matchCounts).boxed().toList());
    }

    private static Map<Integer, Integer> toCountMap(List<Integer> matchCounts) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer match : matchCounts) {
            counts.merge(match, 1, Integer::sum);
        }
        return counts;
    }

    public int countOf(int match) {
        return matchCounts.getOrDefault(match, 0);
    }

    public int prizeOf(int match) {
        return PRIZES.get(match);
    }

    public double profitRate(int amount) {
        long total = 0;
        for (int match : PRIZES.keySet()) {
            total += (long) prizeOf(match) * countOf(match);
        }
        return (double) total / amount;
    }
}