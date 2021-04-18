package lotto.domain;

import java.util.Arrays;

public enum Rank {
    OTHER(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int winningMoney;


    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(value -> matchCount == value.matchCount)
                .findFirst()
                .orElse(Rank.OTHER);
    }

    public int prizeMoney(int count) {
        return this.winningMoney * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
