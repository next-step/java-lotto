package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NO_MATCH(0, 0),
    ;

    private final int matchCount;
    private final int winnings;

    Rank(final int matchCount, final int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank of(final int matchCount) {
        return Arrays.stream(values())
                .filter(v -> v.matchCount == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
