package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FAIL(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2000_000_000, false);

    private final int matchCount;
    private final int profit;
    private final boolean matchBonusBall;

    Rank(int matchCount, int profit, boolean matchBonusBall) {
        this.matchCount = matchCount;
        this.profit = profit;
        this.matchBonusBall = matchBonusBall;
    }

    public static Rank valueOf(int matchCount, boolean matchBonusBall) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount) && rank.matchBonusBall(matchBonusBall))
                .findFirst()
                .orElse(FAIL);
    }

    private boolean matchBonusBall(boolean matchBonusBall) {
        return this.matchBonusBall == matchBonusBall;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int profit() {
        return profit;
    }

    public int matchCount() {
        return matchCount;
    }
}
