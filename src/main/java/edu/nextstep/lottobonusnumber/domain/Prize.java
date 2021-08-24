package edu.nextstep.lottobonusnumber.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 200_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 15_000_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private static final int THIRD_PRIZE_COUNT_OF_MATCH = 5;

    private final int countOfMatch;
    private final int winningPrize;

    Prize(int countOfMatch, int winningPrize) {
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
    }

    public static Prize of(int numOfMatch, boolean hasBonusNumber) {
        if(numOfMatch == THIRD_PRIZE_COUNT_OF_MATCH && !hasBonusNumber) {
            return Prize.THIRD;
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.countOfMatch == numOfMatch)
                .findFirst()
                .orElse(LOSE);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
