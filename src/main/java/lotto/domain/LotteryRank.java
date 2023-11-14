package lotto.domain;

public enum LotteryRank {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L);

    private int matchingCount;
    private long prize;

    LotteryRank(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int matchingCount() {
        return this.matchingCount;
    }

    public static long calculatePrize(LotteryRank rank, long count) {
        return rank.prize * count;
    }
}
