package com.jaeyeonling.lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    LOSE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 150_0000),
    JACKPOT(6, 20_0000_0000);

    private final int countOfMatch;
    private final int prize;

    LottoPrize(final int countOfMatch, final int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public static LottoPrize valueOf(final int countOfMatch) {
        return JACKPOT;
    }
}
