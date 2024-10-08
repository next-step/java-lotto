package model;

import java.util.Arrays;

public enum Prize {
    PRIZE3(3, 5000),
    PRIZE4(4, 50000),
    PRIZE5(5, 1500000),
    PRIZE6(6, 2000000000);

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
        return Arrays.stream(Prize.values())
                .filter(it -> it.matched == matched)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("illegal matched"));
    }
}
