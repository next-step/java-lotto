package lotto.common;

import java.util.Arrays;

public enum WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    WinningType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningType of(int matchCount, boolean matchBonus) {
        if (matchCount >= MISS.matchCount && matchCount < FIFTH.matchCount) {
            return MISS;
        }

        return Arrays.stream(WinningType.values())
                .filter(t -> t.matchCount == matchCount)
                .filter(t -> !t.equals(SECOND) || matchBonus)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

