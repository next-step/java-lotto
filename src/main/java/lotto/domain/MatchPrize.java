package lotto.domain;

import java.util.Arrays;

public enum MatchPrize {
    ZERO(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final long money;

    MatchPrize(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static MatchPrize valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(matchPrize -> matchPrize.matchCount == countOfMatch)
                .findFirst()
                .orElse(ZERO);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }
}
