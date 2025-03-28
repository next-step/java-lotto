package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NO_PRIZE(0, 0, false);

    private final int prize;
    private final int matchCount;
    private final boolean bonusBallMatch;

    Rank(int prize, int matchCount, boolean bonusBallMatch) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonusBallMatch = bonusBallMatch;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        Rank[] values = Rank.values();
        for (Rank value : values) {
            if (value.matchCount == matchCount) {
                return value;
            }
        }

        return NO_PRIZE;
    }

    public static Rank of(int matchCount, boolean bonusBallMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusBallMatch == bonusBallMatch)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
