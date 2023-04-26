package step2;

public enum MatchCount {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    MatchCount(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static MatchCount of(int matchCount) {
        if (matchCount == SIX.matchCount) {
            return SIX;
        }
        if (matchCount == FIVE.matchCount) {
            return FIVE;
        }
        if (matchCount == FOUR.matchCount) {
            return FOUR;
        }
        if (matchCount == THREE.matchCount) {
            return THREE;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
