package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 3000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NO_MATCH(0, 0, false);

    private int matchCount;
    private int winningMoney;
    private boolean isBonusWinner;

    Rank(int matchCount, int winningMoney, boolean isBonusWinner) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isBonusWinner = isBonusWinner;
    }

    public static Rank of(int matchCount, boolean isBonusWinner){
        if (matchCount == 5 && !isBonusWinner) {
            return THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int winningMoney() {
        return this.winningMoney;
    }
}
