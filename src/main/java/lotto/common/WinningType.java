package lotto.common;

public enum WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);
//    SIXTH(2, 0),
//    SEVENTH(1, 0),
//    EIGHTH(0, 0);

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
        return MISS;
    }

    public static WinningType of(int matchCount, boolean matchBonus) {
        for (WinningType winningType : WinningType.values()) {
            if (matchCount < 3) {
                return WinningType.MISS;
            }

            if (matchBonus && matchCount == 5) {
                return WinningType.SECOND;
            }

            if (!matchBonus && matchCount ==5) {
                return WinningType.THIRD;
            }

            if (winningType.matchCount == matchCount) {
                return winningType;
            }
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

