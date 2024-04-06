package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    MISS(6, 0, false, 0);

    private final int rank;
    private final int matchCount;
    private final boolean matchBonus;
    private final int winningsAmount;

    Rank(int rank, int matchCount, boolean matchBonus, int winningsAmount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningsAmount = winningsAmount;
    }

    public static int getWinningsAmount(MatchResult matchResult) {
        return Arrays.stream(Rank.values())
                .filter(value -> isValue(matchResult, value))
                .findAny()
                .orElse(MISS)
                .winningsAmount;
    }

    public static int getRank(MatchResult matchResult) {
        return Arrays.stream(Rank.values())
                .filter(value -> isValue(matchResult, value))
                .findAny()
                .orElse(Rank.MISS)
                .rank;
    }

    private static boolean isValue(MatchResult matchResult, Rank value) {
        return (matchResult.getMatchCount() == value.matchCount) && (matchResult.isMatchBonus() == value.matchBonus);
    }
}
