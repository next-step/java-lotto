package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NO_MATCH(0, 0),
    ;

    private final int countOfMatch;
    private final int winningMoney;

    Rank(final int countOfMatch, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank of(final int countOfMatch) {
        return Arrays.stream(values())
                .filter(v -> v.isSameAsMatchCount(countOfMatch))
                .findFirst()
                .orElse(NO_MATCH);
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
