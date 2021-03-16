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
        return Arrays.stream(values())
                .filter(amount -> amount.count == countWinnings)
                .map(amount -> amount.price)
                .findFirst()
                .orElse(0);
    }
}
