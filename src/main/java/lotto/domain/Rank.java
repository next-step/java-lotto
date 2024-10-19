package lotto.domain;

import java.util.Arrays;

public enum Rank {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_MATCHES_WITH_BONUS(5, 30000000),
    SIX_MATCHES(6, 2000000000),
    NONE(0, 0);
    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOfMatchCount(int matchCount, boolean bonusMatch) {
        if (isSecondPrizeCondition(matchCount, bonusMatch)) {
            return FIVE_MATCHES_WITH_BONUS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecondPrizeCondition(int matchCount, boolean bonusMatch) {
        return matchCount == FIVE_MATCHES.getMatchCount() && bonusMatch;
    }
}
