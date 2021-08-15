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

    private static final Prize[] PRIZES_ARR = Prize.values();
    private final int value;
    private final int prize;

    Prize(int value, int prize) {
        this.value = value;
        this.prize = prize;
    }

    public static Prize from(int value) {
        validateNotPrize(value);
        return PRIZES_ARR[value - 3];
    }

    private static void validateNotPrize(int value) {
        if(value < 3 || value > 6) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 입력값 : " + value);
        }
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }
}
