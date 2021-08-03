package step3.domain;

import java.util.Arrays;

public enum Winning {
    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int price;

    Winning(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Winning find(int count, boolean matchBonus) {
        if (count == SECOND.getMatchCount() && matchBonus) {
            return SECOND;
        }

        if (count == THIRD.getMatchCount() && !matchBonus) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(winning -> isaBoolean(count, winning))
                .findFirst()
                .orElse(NOTHING);
    }

    private static boolean isaBoolean(int count, Winning winning) {
        return winning.matchCount == count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public boolean isNotThing() {
        return NOTHING.equals(this);
    }
}
