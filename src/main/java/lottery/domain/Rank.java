package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FAIL(MatchCount.ZERO, 0),
    FIFTH(MatchCount.THREE, 5_000),
    THIRD(MatchCount.FOUR, 50_000),
    SECOND(MatchCount.FIVE, 1_500_000),
    FIRST(MatchCount.SIX, 2000_000_000);

    private final MatchCount matchCount;
    private final Integer profit;

    Rank(MatchCount matchCount, Integer profit) {
        this.matchCount = matchCount;
        this.profit = profit;
    }

    public static Rank valueOf(MatchCount matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    public int matchCount() {
        return matchCount.count();
    }

    public Integer profit() {
        return profit;
    }
}
