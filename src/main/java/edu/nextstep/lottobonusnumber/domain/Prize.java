package edu.nextstep.lottobonusnumber.domain;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSE(0, false, 0),;

    Prize(int countOfMatch, boolean hasBonusNumber, int winningPrize) {

    }

    public static Prize of(int countOfMatching, boolean hasBonusNumber) {
        return null;
    }
}
