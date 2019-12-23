package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    private boolean hasEqual(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static Rank of(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hasEqual(matchCount))
                .filter(rank -> !rank.equals(SECOND) || hasBonusNumber)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
