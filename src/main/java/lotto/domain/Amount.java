package lotto.domain;

import java.util.Arrays;

public enum Amount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final int price;

    Amount(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public static int getWinningMoney(int countWinnings) {
        MatchPrice matchPrice = new MatchPrice();

        for (Amount amount : values()) {
            matchPrice(amount, countWinnings, matchPrice);
        }

        return matchPrice.getMatchPrice();
    }

    public static void matchPrice(Amount amount, int countWinnings, MatchPrice matchPrice) {
        if (amount.count == countWinnings) {
            matchPrice.matching(amount.price);
        }
    }
}
