package lotto.model;

import java.util.Arrays;

public enum Rank {
    MISS(0, new Money(0)),
    FIVE(3, new Money(5_000)),
    FOUR(4, new Money(50_000)),
    THREE(5, new Money(1_500_000)),
    TWO(5, new Money(30_000_000)),
    ONE(6, new Money(2_000_000_000));

    private final int order;
    private final Money money;

    Rank(int order, Money money) {
        this.order = order;
        this.money = money;
    }

    public int calculatePrice(int value) {
        return money.total(value);
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
        return money.getPrice();
    }
}
