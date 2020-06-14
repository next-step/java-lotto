package dev.dahye.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NO_RANK(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 3000000, true),
    FIRST(6, 2000000000, false);

    private int countOfMatch;
    private long prize;
    private boolean isMatchBonusNumber;

    Rank(int countOfMatch, long prize, boolean isMatchBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    private boolean same(int countOfMatch, boolean isMatchBonusNumber) {
        return (this.countOfMatch == countOfMatch && this.isMatchBonusNumber == isMatchBonusNumber);
    }

    public static Rank valueOf(int countOfMatch, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.same(countOfMatch, isMatchBonusNumber))
                .findFirst()
                .orElse(NO_RANK);
    }
}
