package step4.domain;

import java.util.Arrays;

public enum WinningPrice {
    FIRST_PRICE(6, 2_000_000_000),
    SECOND_PRICE(5, 30_000_000),
    THIRD_PRICE(5, 1_500_000),
    FOURTH_PRICE(4, 50_000),
    FIFTH_PRICE(3, 5_000),
    OTHER(0, 0);

    private int winningNumbers;
    private int price;

    WinningPrice(int winningNumbers, int price) {
        this.winningNumbers = winningNumbers;
        this.price = price;
    }

    public boolean checkCount(int winningNumber) {
        return winningNumbers == winningNumber;
    }

    public int getWinningNumbers() {
        return winningNumbers;
    }

    public int getPrice() {
        return price;
    }

    public static WinningPrice valueOf(int winningCount, boolean matchBonus) {

        WinningPrice[] winningPrices = values();
        if (winningCount == SECOND_PRICE.winningNumbers && matchBonus) {
            return WinningPrice.SECOND_PRICE;
        }

        if (winningCount == SECOND_PRICE.winningNumbers && !matchBonus) {
            return WinningPrice.THIRD_PRICE;
        }

        return Arrays.stream(winningPrices)
                .filter(priceValue -> priceValue.checkCount(winningCount))
                .findAny()
                .orElse(OTHER);
    }
}
