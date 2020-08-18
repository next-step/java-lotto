package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int hitNumber;
    private final int money;

    Rank(int hitNumber, int money) {
        this.hitNumber = hitNumber;
        this.money = money;
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public int getMoney() {
        return money;
    }

    public static Rank valueOf(int hitNumber, boolean matchBonus) {
        if (hitNumber == 5) {
            return matchBonus ? Rank.SECOND : Rank.THIRD;
        }

        return Arrays.stream(values()).
                filter(it -> it.getHitNumber() == hitNumber)
                .findFirst()
                .orElse(MISS);
    }

}
