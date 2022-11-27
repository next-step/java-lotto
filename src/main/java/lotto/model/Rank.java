package lotto.model;

import java.util.Arrays;

public enum Rank {
    MISS(0, new Money(0)),
    FIVE(3, new Money(5_000)),
    FOUR(4, new Money(50_000)),
    THREE(5, new Money(1_500_000)),
    TWO(5, new Money(30_000_000)),
    ONE(6, new Money(2_000_000_000));

    private final int ranking;
    private final Money money;

    Rank(int ranking, Money money) {
        this.ranking = ranking;
        this.money = money;
    }

    public int calculatePrice(int value) {
        return money.total(value);
    }

    public static Rank findRank(int count, boolean isBonus) {
        if (count == TWO.ranking && isBonus) {
            return TWO;
        }

        if (count == THREE.ranking && !isBonus) {
            return THREE;
        }

        return Arrays.stream(Rank.values())
                .filter(value -> count == value.ranking)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrice() {
        return money.getPrice();
    }
}
