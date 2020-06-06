package dev.dahye.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int prize;

    Rank(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    private boolean same(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public static boolean canRanking(int countOfMatch) {
        return Arrays.stream(Rank.values())
                .anyMatch(winning -> winning.same(countOfMatch));
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(winning -> winning.same(countOfMatch))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
