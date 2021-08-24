package edu.nextstep.lottobonusnumber.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSE(0, false, 0);

    private final int countOfMatch;
    private final boolean hasBonusNumber;
    private final int winningPrize;

    Prize(int countOfMatch, boolean hasBonusNumber, int winningPrize) {
        this.countOfMatch = countOfMatch;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrize = winningPrize;
    }

    public static Prize of(int countOfMatch, boolean hasBonusNumber) {

        if (countOfMatch == 5 && !hasBonusNumber) {
            return THIRD;
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LOSE);
    }
}
