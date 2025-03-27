package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    private static final int PRIZE_MATCH_THREE = 5_000;
    private static final int PRIZE_MATCH_FOUR = 50_000;
    private static final int PRIZE_MATCH_FIVE = 1_500_000;
    private static final int PRIZE_MATCH_SIX = 2_000_000_000;

    private final Map<Integer, Integer> matchCounts = new HashMap<>();

    public LottoResult() {
        matchCounts.put(MATCH_THREE, 0);
        matchCounts.put(MATCH_FOUR, 0);
        matchCounts.put(MATCH_FIVE, 0);
        matchCounts.put(MATCH_SIX, 0);
    }

    public void add(int matchCount) {
        if (matchCount >= MATCH_THREE) {
            matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
        }
    }

    public int getMatchCount(int matchNumber) {
        return matchCounts.getOrDefault(matchNumber, 0);
    }

    public long calculateTotalPrize() {
        return (long) matchCounts.get(MATCH_THREE) * PRIZE_MATCH_THREE
                + (long) matchCounts.get(MATCH_FOUR) * PRIZE_MATCH_FOUR
                + (long) matchCounts.get(MATCH_FIVE) * PRIZE_MATCH_FIVE
                + (long) matchCounts.get(MATCH_SIX) * PRIZE_MATCH_SIX;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount;
    }
}
