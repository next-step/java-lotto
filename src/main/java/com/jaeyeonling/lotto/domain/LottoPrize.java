package com.jaeyeonling.lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    LOSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    JACKPOT(6, 2_000_000_000);

    private final int countOfMatch;
    private final long prizeMoney;
    private final boolean matchBonus;

    LottoPrize(final int countOfMatch,
               final int prizeMoney) {
        this(countOfMatch, prizeMoney, false);
    }

    LottoPrize(final int countOfMatch,
               final int prizeMoney,
               final boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public static LottoPrize valueOf(final int countOfMatch,
                                     final boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchBonus == matchBonus)
                .filter(prize -> prize.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LOSE);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
