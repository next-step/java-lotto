package study.step3.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, false, 5000, "5등"),
    FOURTH(4, false, 50000, "4등"),
    THIRD(5, false, 1500000, "3등"),
    SECOND(5, true, 30000000, "2등"),
    FIRST(6, false, 2000000000, "1등"),
    NO_HIT(0, false, 0, "미당첨");


    private final int hitCount;
    private final boolean isBonus;
    private final int amount;
    private final String message;

    Rank(int hitCount, boolean isBonus, int amount, String message) {
        this.hitCount = hitCount;
        this.isBonus = isBonus;
        this.amount = amount;
        this.message = message;
    }

    public static Rank valueOf(int hitCount, boolean isBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.condition(hitCount, isBonus))
            .findAny()
            .orElse(NO_HIT);
    }

    private boolean condition(int hitCount, boolean isBonus) {
        return this.hitCount == hitCount && this.isBonus == isBonus;
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

    public boolean isBonus() {
        return isBonus;
    }
}
