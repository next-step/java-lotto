package lotto.result;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchedNumbersCount;
    private final int prize;

    Rank(int matchedNumbersCount, int prize) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prize = prize;
    }

    public int value() {
        return matchedNumbersCount;
    }

    public boolean isEqualsTo(long count) {
        return matchedNumbersCount == count;
    }

    public int price() {
        return prize;
    }

    public long totalPrize(Long quantity) {
        return prize * quantity;
    }
}
