package lotto.common;

public enum WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    private final int matchCount;
    private final int prize;

    WinningType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningType of(int matchCount) {
        for (WinningType winningType : WinningType.values()) {
            if (winningType.matchCount == matchCount) {
                return winningType;
            }
        }
        return SEVENTH;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

