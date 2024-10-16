package lotto.domain;

import java.util.Arrays;

public enum Winning {
    NONE(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Winning fromMatchCount(int matchCount) {
        return Arrays.stream(values())
                     .filter(winning -> winning.matchCount == matchCount)
                     .findFirst()
                     .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
