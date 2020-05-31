package dev.dahye.lotto.domain;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int matchCount;
    private int prize;

    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    private boolean sameMathCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static boolean isWinning(int matchCount) {
        return Arrays.stream(Winning.values())
                .anyMatch(winning -> winning.sameMathCount(matchCount));
    }

    public static Winning getWinning(int matchCount) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.sameMathCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
