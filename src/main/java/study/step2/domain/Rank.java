package study.step2.domain;

import java.util.Arrays;

public enum Rank {

    FOURTH(3, 5000, "4등"),
    THIRD(4, 50000, "3등"),
    SECOND(5, 1500000, "2등"),
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

    public static Rank valueOfHitCount(int hitCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.hitCountEquals(hitCount))
            .findAny()
            .orElse(NO_HIT);
    }

    private boolean hitCountEquals(int hitCount) {
        return this.hitCount == hitCount;
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
}
