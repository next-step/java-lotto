package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 3_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
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
        if (matchCount == 5 && isBonusWinner) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
