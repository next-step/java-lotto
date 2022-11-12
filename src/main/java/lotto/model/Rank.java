package lotto.model;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4,50_000),
    FIVE(5,1_500_000),
    SIX(6,2_000_000_000);

    private final int order;
    private final int price;

    Rank(int order, int price) {
        this.order = order;
        this.price = price;
    }

    public int calculatePrice(int value) {
        return this.price * value;
    }

    public static Rank findRank(int count) {
        return Arrays.stream(Rank.values())
                .filter(value -> count == value.count())
                .findFirst()
                .orElse(MISS);
    }

    public int count() {
        return this.order;
    }

    public int getPrice() {
        return price;
    }
}
