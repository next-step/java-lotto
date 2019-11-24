package step4.model;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final int MIN_MATCH_COUNT = 3;

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public boolean useBonusNo() {
        return this == SECOND;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public Money getPrize() {
        return new Money(this.prize);
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        Rank rank = valueOf(matchCount);
        if (matchCount == SECOND.matchCount) {
            return matchBonus ? SECOND : THIRD;
        }
        return rank;
    }

    public static Rank valueOf(int matchCount) {
        if (matchCount < MIN_MATCH_COUNT) {
            return MISS;
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }
}
