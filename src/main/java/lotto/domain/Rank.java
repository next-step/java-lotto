package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    MISS(0,0);

    private int matchNums;
    private int winningMoney;

    Rank(int matchNums, int winningMoney) {
        this.matchNums = matchNums;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchNums) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNums == matchNums)
                .findAny()
                .orElse(MISS);
    }
}
