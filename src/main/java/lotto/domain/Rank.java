package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(5, 50_000),
    FOURTH(4, 5_000),
    FIFTH(3, 0),
    NOTHING(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank from(int matchCount, boolean matchBonus) {
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int price() {
        return this.money;
    }

    public long calcTotalPrice(int count) {
        return (long) this.money * count;
    }
}
