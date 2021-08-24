package edu.nextstep.lottobonusnumber.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSE(0, false, 0),
    ;

    private static final int THIRD_PRIZE_COUNT_OF_MATCH = 5;

    private final int countOfMatch;
    private final boolean hasBonusNumber;
    private final long winningPrize;

    Prize(int countOfMatch, boolean hasBonusNumber, int winningPrize) {
        this.countOfMatch = countOfMatch;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrize = winningPrize;
    }

    public static Prize of(int countOfMatch, boolean hasBonusNumber) {

        if (countOfMatch == THIRD_PRIZE_COUNT_OF_MATCH && !hasBonusNumber) {
            return THIRD;
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LOSE);
    }

    public long calculatePrize(int countOfWinningResult) {
        return winningPrize * countOfWinningResult;
    }

    @Override
    public String toString() {
        return countOfMatch + "개 일치 (" +
                winningPrize + " 원)- ";
    }
}
