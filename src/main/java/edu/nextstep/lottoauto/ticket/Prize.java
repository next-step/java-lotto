/*
 * Prize.java (enum)
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticket;

public enum Prize {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 200_000_000);

    private final int value;
    private final int prize;

    Prize(int value, int prize) {
        this.value = value;
        this.prize = prize;
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }
}
