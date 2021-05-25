package lotto.common;

import java.util.Arrays;

public enum WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    SIXTH(2, 0),
    SEVENTH(1, 0),
    EIGHTH(0, 0);

    private final int matchCount;
    private final int prize;

    WinningType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningType of(int matchCount, boolean matchBonus) {
        if (matchBonus && matchCount == 5) {
            return SECOND;
        }

        if (!matchBonus && matchCount == 5) {
            return THIRD;
        }

        return Arrays.stream(WinningType.values())
                .filter(t -> t.matchCount == matchCount)
                .findFirst()
                .orElse(EIGHTH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

