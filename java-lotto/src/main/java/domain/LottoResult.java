package domain;

import java.util.Map;

public class LottoResult {
    public static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private final Map<Integer, Integer> matchCounts;

    public LottoResult(Map<Integer, Integer> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public double calculateProfitRate(int totalSpent) {
        int totalPrize = matchCounts.entrySet().stream()
                .mapToInt(entry -> PRIZE_MONEY.getOrDefault(entry.getKey(), 0) * entry.getValue())
                .sum();
        return (double) totalPrize / totalSpent;
    }

    public Map<Integer, Integer> getMatchCounts() {
        return matchCounts;
    }
}
