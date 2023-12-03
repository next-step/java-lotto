package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 150000000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchCount;
    private final long prizeAmount;

    Rank(int matchCount, long prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public long prizeAmount() {
        return this.prizeAmount;
    }

    public static Rank rankByMatchCount(int matchCount) {
        if (matchCount == 6) {
            return Rank.FIRST;
        }

        if (matchCount == 5) {
            return Rank.SECOND;
        }

        if (matchCount == 4) {
            return Rank.THIRD;
        }

        if (matchCount == 3) {
            return Rank.FOURTH;
        }

        throw new IllegalArgumentException();
    }
}
