package lotto;

import java.util.Arrays;

public enum WinningType {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    FIRST(6, 2000000000);
    private final int matchNumberCount;
    private final int winnings;

    WinningType(int matchNumberCount, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.winnings = winnings;
    }

    public static boolean isWinningTypeNumber(int matchNumberCount) {
        return FIFTH.matchNumberCount <= matchNumberCount && matchNumberCount <= FIRST.matchNumberCount;
    }

    public int matchNumberCount() {
        return matchNumberCount;
    }

    public int winnings() {
        return winnings;
    }

    public static WinningType valueOf(int matchNumberCount) {
        return Arrays.stream(WinningType.values())
                .filter(type -> matchNumberCount == type.matchNumberCount)
                .findAny()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치(%d원)", matchNumberCount, winnings);
    }
}
