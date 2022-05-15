package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    LOST(0);

    private final int matchCount;

    Rank(int matchCount) {
        this.matchCount = matchCount;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findAny()
                .orElse(LOST);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
