package lotto.model;

import java.util.Arrays;

public enum WinningPrice {
    NOTWIN(2, 0),
    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int winningCount;
    private final int price;

    WinningPrice(int winningCount, int price) {
        this.winningCount = winningCount;
        this.price = price;
    }

    public static WinningPrice of(int winningCount, boolean isBonusMatch) {
        if (winningCount == SECOND.winningCount && isBonusMatch) {
            return SECOND;
        }

        return Arrays.stream(values()).filter(
                it -> it.winningCount == winningCount)
                .findFirst()
                .orElse(NOTWIN);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrice() {
        return price;
    }
}

