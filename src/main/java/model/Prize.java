package model;

import java.util.Arrays;

public enum Prize {
    PRIZE3(3, 5_000),
    PRIZE4(4, 50_000),
    PRIZE5(5, 1_500_000),
    PRIZE5_PLUS(5, 30_000_000),
    PRIZE6(6, 2_000_000_000);

    private int matched;
    private int price;

    Prize(int matched, int price) {
        this.matched = matched;
        this.price = price;
    }

    public int getMatched() {
        return matched;
    }

    public int getPrice() {
        return price;
    }

    public static Prize getPrize(int matched) {
        return getPrize(matched, false);
    }

    public static Prize getPrize(int matched, boolean isBonusMatched) {
        if (isBonusMatched && matched == PRIZE5_PLUS.matched) {
            return PRIZE5_PLUS;
        }
        return Arrays.stream(Prize.values())
                .filter(it -> it.matched == matched)
                .findFirst()
                .orElse(null);
    }
}
