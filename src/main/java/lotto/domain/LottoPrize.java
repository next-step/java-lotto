package lotto.domain;

public enum LottoPrize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000L);

    private final int matchCount;
    private final long prize;

    LottoPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public static long getPrizeByMatchCount(int count) {
        for (LottoPrize lottoPrize : values()) {
            if (lottoPrize.getMatchCount() == count) {
                return lottoPrize.getPrize();
            }
        }
        return 0;
    }
}