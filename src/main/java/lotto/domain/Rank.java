package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    NON_MATCH(0, 0);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank match(int count) {
        for(Rank rank : values()) {
            if (rank.count == count) {
                return rank;
            }
        }
        return NON_MATCH;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }
}
