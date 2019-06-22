package com.jaeyeonling.lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    LOSE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    JACKPOT(6, 2_000_000_000);

    private final int countOfMatch;
    private final long prizeMoney;

    LottoPrize(final int countOfMatch, final int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize valueOf(final int countOfMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LOSE);
    }
}
