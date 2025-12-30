package lotto;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int matchCount() {
        return matchCount;
    }

    public long prize() {
        return prize;
    }

    public static boolean isWinning(int matchCount) {
        return Arrays.stream(values()).anyMatch(r -> r.matchCount == matchCount);
    }

    public static Rank from(int matchCount) {
        return Arrays.stream(values())
            .filter(r -> r.matchCount == matchCount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("당첨 등수가 없다."));
    }
}
