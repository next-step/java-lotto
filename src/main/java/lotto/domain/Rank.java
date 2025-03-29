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
    private final boolean isBonusNumberRequired;

    Rank(int prize, int matchCount, boolean isBonusNumberRequired) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonusNumberRequired = isBonusNumberRequired;
    }

    public static Rank of(int matchCount, boolean bonusNumberMatch) {
        if (isSecondRank(matchCount, bonusNumberMatch)) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && !rank.isBonusNumberRequired)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    private static boolean isSecondRank(int matchCount, boolean bonusNumberMatch) {
        return SECOND.matchCount == matchCount && bonusNumberMatch;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
