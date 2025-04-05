package lotto;

import java.util.Map;

public enum LottoPrize {
    SIX_MATCH(6, 2000000000),
    FIVE_MATCH(5, 1500000),
    FOUR_MATCH(4, 50000),
    THREE_MATCH(3, 5000),
    TWO_MATCH(2, 0),
    ONE_MATCH(1, 0),
    ZERO_MATCH(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize getPrize(int matchCount) {
        for (LottoPrize prize : values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        throw new IllegalArgumentException("Invalid match count: " + matchCount);
    }

    public static int calculateTotalWinningAmount(Map<Integer, Integer> matchCounts) {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : matchCounts.entrySet()) {
            int matches = entry.getKey();
            int count = entry.getValue();
            LottoPrize prize = getPrize(matches);
            totalAmount += prize.calculateWinningAmount(count);
        }
        return totalAmount;
    }

    public int calculateWinningAmount(int count) {
        return prizeMoney * count;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치 (" + prizeMoney + "원)";
    }
}
