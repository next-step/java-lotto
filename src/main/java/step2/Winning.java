package step2;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
    public int getPrize() {
        return prize;
    }
    public static Winning valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(winning -> winning.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}
