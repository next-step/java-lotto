package lotto.domain;

public enum Rank {
    NO_RANK_ZERO(0, 0),
    NO_RANK_ONE(1, 0),
    NO_RANK_TWO(2, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
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
