package lotto.enums;

import java.util.Arrays;

public enum MatchType {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 150_000),
    SIX(6, 2_000_000_000),
    BONUS(7, 30_000_000),
    DEFAULT(0, 0);

    private int match;
    private int price;

    MatchType(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public int getMatch() {
        return this.match;
    }

    public int getPrice() {
        return this.price;
    }

    public static MatchType getMatchType(int num) {
       return Arrays.stream(MatchType.values())
                .filter(value -> value.match == num)
                .findFirst()
                .orElse(DEFAULT);
    }
}
