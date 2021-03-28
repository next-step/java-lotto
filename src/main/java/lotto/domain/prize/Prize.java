package lotto.domain.prize;

public enum Prize {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L);

    private long equalNumberCount;
    private long prizeAmount;

    Prize(long equalNumberCount, long prizeAmount) {
        this.equalNumberCount = equalNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public static long getPrizeByEqualNumberCount(long equalNumberCount) {
        return 0;
    }

}
