package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_MATCH(0, 0),
    ;

    private final int countOfMatch;
    private final int winningMoney;

    Rank(final int countOfMatch, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank of(final int countOfMatch, final boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(v -> v.isSameAsMatchCount(countOfMatch))
                .map(v -> getRankWithBonusNumber(v, isMatchBonus))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private static Rank getRankWithBonusNumber(final Rank rank, final boolean isMatchBonus) {
        if (!(SECOND == rank || THIRD == rank)) {
            return rank;
        }
        if (isMatchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public long totalMoney(final long count) {
        return this.winningMoney * count;
    }

    private boolean isSameAsMatchCount(final int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
