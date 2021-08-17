package Lotto;

import java.util.Arrays;


public enum WinningPrice {

    NOT_WINNINGS(0, 0, false),
    THREE_WINNINGS(3, 5_000, false),
    FOUR_WINNINGS(4, 50_000, false),
    FIVE_WINNINGS(5, 1_500_000, true),
    FIVE_WINNINGS_BOBUS(5, 30_000_000, true),
    SIX_WINNINGS(6, 2_000_000_000, false);

    public final int match;
    public final int price;
    public final boolean bonus;


    WinningPrice(int match, int price, boolean bonus) {
        this.match = match;
        this.price = price;
        this.bonus = bonus;
    }

    public static WinningPrice getWinnings(int numberOfMatch, boolean matchBonus) {

        return Arrays.stream(values())
                .filter(winningPrice -> (winningPrice.bonus == false) ? winningPrice.match == numberOfMatch : winningPrice.price == findBonusWinnings(matchBonus).price)
                .findFirst()
                .orElse(NOT_WINNINGS);
    }

    public static WinningPrice findBonusWinnings(boolean matchBonus) {
        if (matchBonus) {
            return WinningPrice.FIVE_WINNINGS_BOBUS;
        }
        return WinningPrice.FIVE_WINNINGS;
    }
}
