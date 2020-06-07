package dev.dahye.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 3000000, true),
    FIRST(6, 2000000000, false);

    private int countOfMatch;
    private int prize;
    private boolean isMatchBonusNumber;

    Rank(int countOfMatch, int prize, boolean isMatchBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    private boolean same(int countOfMatch, boolean isMatchBonusNumber) {
        return (this.countOfMatch == countOfMatch && this.isMatchBonusNumber == isMatchBonusNumber);
    }

    public static boolean canRanking(int countOfMatch, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .anyMatch(winning -> winning.same(countOfMatch, isMatchBonusNumber));
    }

    public static Rank valueOf(int countOfMatch, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(winning -> winning.same(countOfMatch, isMatchBonusNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
