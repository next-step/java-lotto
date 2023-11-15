package lotto.domain.lotto;

public enum LotteryRank {

    FOURTH(3, 5_000L),
    THIRD(4, 50_000L),
    SECOND(5, 1_500_000L),
    FIRST(6, 2_000_000_000L);

    private int matchingCount;
    private long prize;

    LotteryRank() {
    }

    LotteryRank(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int matchingCount() {
        return this.matchingCount;
    }

    public boolean equalsWith(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public long prize() {
        return this.prize;
    }
}
