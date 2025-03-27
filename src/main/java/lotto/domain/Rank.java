package lotto.domain;

public enum Rank {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    NO_PRIZE(0, 0);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        Rank[] values = Rank.values();
        for (Rank value : values) {
            if (value.matchCount == matchCount) {
                return value;
            }
        }

        return NO_PRIZE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
