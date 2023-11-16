package lotto.domain;

public enum Rank {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    Four(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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
