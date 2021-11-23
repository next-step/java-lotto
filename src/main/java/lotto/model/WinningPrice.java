package lotto.model;

import java.util.Arrays;

public enum WinningPrice {
    NOTWIN(2, 0),
    FORTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int winningCount;
    private final int price;

    WinningPrice(int winningCount, int price) {
        this.winningCount = winningCount;
        this.price = price;
    }

    public static WinningPrice of(int winningCount) {
        return Arrays.stream(values()).filter(it -> it.winningCount == winningCount)
                .findFirst()
                .orElse(NOTWIN);
    }

    public int getPrice() {
        return price;
    }
}

