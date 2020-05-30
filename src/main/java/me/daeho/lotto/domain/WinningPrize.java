package me.daeho.lotto.domain;


import java.util.Arrays;

public enum WinningPrize {
    NOT_MATCH(0, 0),
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6,2000000000)
    ;

    private final int count;
    private final int prize;

    WinningPrize(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }


    public static int getCountBy(int prize) {
        return Arrays.stream(values()).filter(v -> v.getPrize() == prize).findAny().orElse(NOT_MATCH).getCount();
    }

    public static int getPrizeBy(int count) {
        return Arrays.stream(values()).filter(v -> v.getCount() == count).findAny().orElse(NOT_MATCH).getPrize();
    }
}
