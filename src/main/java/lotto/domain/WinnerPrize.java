package lotto.domain;

import java.util.stream.Stream;

public enum WinnerPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final long prize;

    WinnerPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public static WinnerPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return getFiveMatchPrize(matchBonus);
        }

        return Stream.of(values())
                .filter(winnerPrize -> winnerPrize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(WinnerPrize.MISS);

    }

    private static WinnerPrize getFiveMatchPrize(boolean matchBonus) {
        if (matchBonus) {
            return WinnerPrize.SECOND;
        }
        return WinnerPrize.THIRD;
    }
}
