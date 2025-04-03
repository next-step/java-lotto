package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NO_MATCH(0, false, 0, "0개 일치"),
    THREE_MATCH(3, false, 5_000, "3개 일치"),
    FOUR_MATCH(4, false, 50_000, "4개 일치"),
    FIVE_MATCH(5, false, 1_500_000, "5개 일치"),
    FIVE_MATCH_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, false, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String description;

    Rank(int matchCount, boolean bonusMatch, int prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusMatch == bonusMatch)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }
}
