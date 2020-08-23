package step2.domain;

import java.util.Arrays;

public enum WinningPrice {
    FIRST_PRIZE(6, 2000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    OTHER(0, 0);

    private int winningNumbers;
    private int price;


    WinningPrice(int winningNumbers, int price) {
        this.winningNumbers = winningNumbers;
        this.price = price;
    }

    public boolean checkCount(int winningNumber) {
        return (winningNumbers == winningNumber);
    }

    public int getWinningNumbers() {
        return winningNumbers;
    }

    public int getPrice() {
        return price;
    }

    public static WinningPrice valueOf(int winningNumbers) {
        return Arrays.stream(WinningPrice.values())
                .filter(priceValue -> priceValue.checkCount(winningNumbers))
                .findAny()
                .orElse(OTHER);
    }
}
