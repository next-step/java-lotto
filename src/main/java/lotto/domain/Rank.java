package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0,0);

    private int matchNums;
    private int winningMoney;

    Rank(int matchNums, int winningMoney) {
        this.matchNums = matchNums;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchNums, boolean matchBonus) {
        if (matchNums == SECOND.matchNums && matchBonus) {
            return SECOND;
        }
        if (matchNums == THIRD.matchNums) {
            return THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNums == matchNums)
                .findAny()
                .orElse(MISS);
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
