package study.step3.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5000, "5등"),
    FOURTH(4, 50000, "4등"),
    THIRD(5, 1500000, "3등"),
    SECOND(5, 30000000, "2등"),
    FIRST(6, 2000000000, "1등"),
    NO_HIT(0, 0, "미당첨");


    private final int hitCount;
    private final int amount;
    private final String message;

    Rank(int hitCount, int amount, String message) {
        this.hitCount = hitCount;
        this.amount = amount;
        this.message = message;
    }

    public static Rank valueOf(int hitCount, boolean isBonus) {
        return Arrays.stream(values())
            .map(rank -> rank.condition(hitCount, isBonus))
            .filter(Rank::isHit)
            .findFirst()
            .orElse(NO_HIT);
    }

    private Rank condition(int hitCount, boolean isBonus) {
        if (hitCount == 5 && isBonus) {
            return SECOND;
        }
        if (this.hitCount == hitCount) {
            return this;
        }
        return NO_HIT;
    }

    public boolean isHit() {
        return this != NO_HIT;
    }

    public int hitCount() {
        return hitCount;
    }

    public int amount() {
        return amount;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
