package lotto.enums;

import java.util.Arrays;

public enum MatchType {

    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 150_000, false),
    SIX(6, 2_000_000_000, false),
    BONUS(5, 30_000_000, true),
    DEFAULT(0, 0, false);

    private int match;
    private int price;
    private boolean bonus;

    MatchType(int match, int price, boolean bonus) {
        this.match = match;
        this.price = price;
        this.bonus = bonus;
    }

    public int getMatch() {
        return this.match;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isMatching(int count) {
        return this.match == count;
    }

    public static MatchType getMatchType(int num, boolean bonus) {
       return Arrays.stream(MatchType.values())
               .filter(value -> value.match == num && value.bonus == bonus)
               .findFirst()
               .orElse(DEFAULT);
    }
}
