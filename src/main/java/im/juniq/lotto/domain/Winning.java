package im.juniq.lotto.domain;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2000000000L),
    SECOND(5, 30000000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L),
    LOSING(2, 0L);

    private final int matchedCount;
    private final Long amount;

    Winning(int matchedCount, Long amount) {
        this.matchedCount = matchedCount;
        this.amount = amount;
    }

    public static Winning findByMatchedCount(int numberOfMatchedWinningNumber, boolean matchedBonus) {
        if (Winning.THIRD.matchedCount == numberOfMatchedWinningNumber && !matchedBonus) {
            return Winning.THIRD;
        }

        return Arrays.stream(Winning.values())
            .filter(winning -> winning.matchedCount == numberOfMatchedWinningNumber).findFirst()
            .orElse(LOSING);
    }

    public int matchedCount() {
        return matchedCount;
    }

    public Long amount() {
        return amount;
    }
}
