package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FAIL(MatchCount.ZERO, 0),
    FIFTH(MatchCount.THREE, 5000),
    THIRD(MatchCount.FOUR, 50000),
    SECOND(MatchCount.FIVE, 1500000),
    FIRST(MatchCount.SIX, 2000000000);

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
        return matchCount.getCount();
    }

    public Integer profit() {
        return profit;
    }
}
