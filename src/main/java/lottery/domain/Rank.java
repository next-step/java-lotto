package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2000_000_000);

    private final int matchCount;
    private final int profit;

    Rank(int matchCount, int profit) {
        this.matchCount = matchCount;
        this.profit = profit;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchBonus && isSameMatchCount(matchCount, SECOND)) {
            return SECOND;
        }

        return valueOf(matchCount);
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchCount(matchCount, rank))
                .findFirst()
                .orElse(FAIL);
    }

    private static boolean isSameMatchCount(int matchCount, Rank rank) {
        return rank.matchCount == matchCount;
    }

    public int profit() {
        return profit;
    }

    public int matchCount() {
        return matchCount;
    }
}
