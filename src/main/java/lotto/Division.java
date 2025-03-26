package lotto;

import java.util.Arrays;

public enum Division {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private int matchCount;
    private int prize;

    private Division(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Division getDivision(int matchCount) {
        return Arrays.stream(values())
                .filter(division -> division.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
