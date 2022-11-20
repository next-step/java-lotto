package lotto.model;

import java.util.Arrays;

public enum Rank {
    MISS(0, new Price(0)),
    FIVE(3, new Price(5_000)),
    FOUR(4, new Price(50_000)),
    THREE(5, new Price(1_500_000)),
    TWO(5, new Price(30_000_000)),
    ONE(6, new Price(2_000_000_000));

    private final int order;
    private final Price price;

    Rank(int order, Price price) {
        this.order = order;
        this.price = price;
    }

    public int calculatePrice(int value) {
        return price.total(value);
    }

    public static Rank findRank(int count, boolean isBonus) {
        if (count == 5 && isBonus) {
            return TWO;
        }

        if (count == 5 && !isBonus) {
            return THREE;
        }

        return Arrays.stream(Rank.values())
                .filter(value -> count == value.order)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrice() {
        return price.getPrice();
    }
}
