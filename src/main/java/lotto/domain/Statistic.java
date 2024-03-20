package lotto.domain;

import java.util.Arrays;

public enum Statistic {

    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6);

    Statistic(int price, int matcher) {
        this.price = price;
        this.matcher = matcher;
    }

    private int price;
    private int matcher;

    public int getPrice() {
        return price;
    }

    public int getMatcher() {
        return matcher;
    }

    public static Statistic valueOfMatchNumber(int featNumberCount) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matcher == featNumberCount)
                .findFirst()
                .orElseGet(() -> null);
    }
}
