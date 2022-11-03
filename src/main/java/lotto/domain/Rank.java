package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0),
    ;

    private final int countOfMatch;
    private final int winningMoney;

    Rank(final int countOfMatch, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank of(final int countOfMatch, final boolean isMatchBonus) {
        if (SECOND.isSameAsMatchCount(countOfMatch)) {
            return rankSecondAndThird(isMatchBonus);
        }

        return Arrays.stream(values())
                .filter(v -> v.isSameAsMatchCount(countOfMatch))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private static Rank rankSecondAndThird(final boolean isMatchBonus) {
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
