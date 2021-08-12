package Lotto;

import java.util.Arrays;


public enum WinningPrice {


    THREE_WINNINGS(3, 5000),
    FOUR_WINNINGS(4, 50000),
    FIVE_WINNINGS(5, 1500000),
    SIX_WINNINGS(6, 2000000000);

    public final int match;
    public final int price;

    WinningPrice(int match, int price) {
        this.match = match;
        this.price = price;
    }


    public static WinningPrice getWinnings(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(winningPrice -> winningPrice.match == numberOfMatch)
                .findFirst()
                .orElse(null);
    }


}
