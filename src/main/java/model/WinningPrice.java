package model;

import java.util.Arrays;

public enum WinningPrice {

    NONE(0, 0),
    FIRST(2000000000, 6),
    SECOND(150000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3);

    private final int amount;
    private final int matchingCount;

    WinningPrice(final int amount, final int matchingCount) {
        this.amount = amount;
        this.matchingCount = matchingCount;
    }

    public static WinningPrice getWinningPrice(int count) {
        return Arrays.stream(WinningPrice.values())
                .filter(winningPrice -> winningPrice.matchingCount == count)
                .findFirst()
                .orElse(NONE);
    }

    public int getAmount() {
        return amount;
    }
}
