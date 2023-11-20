package lotto.domain;

public enum Rank {
    NO_RANK(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    final private int count;
    final private long prize;

    Rank(int count, long prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }
}