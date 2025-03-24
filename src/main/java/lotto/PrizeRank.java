package lotto;

public enum PrizeRank {
    FIRST(new MatchCount(6), 2_000_000_000),
    SECOND(new MatchCount(5), 1_500_000),
    THIRD(new MatchCount(4), 50_000),
    FOURTH(new MatchCount(3), 5_000),
    NONE(new MatchCount(0), 0);

    private final MatchCount matchCount;
    private final int prize;

    PrizeRank(MatchCount matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static PrizeRank of(MatchCount matchCount) {
        if (matchCount.equals(FIRST.matchCount)) {
            return FIRST;
        }
        if (matchCount.equals(SECOND.matchCount)) {
            return SECOND;
        }
        if (matchCount.equals(THIRD.matchCount)) {
            return THIRD;
        }
        if (matchCount.equals(FOURTH.matchCount)) {
            return FOURTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
