package lottery.domain;

public enum LotteryRanks {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3,5_000);

    private final int requiredNumberCounts;
    private final long prizeMoney;

    private LotteryRanks(int requiredNumberCounts, long prizeMoney) {
        this.requiredNumberCounts = requiredNumberCounts;
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getRequiredNumberCounts() {
        return requiredNumberCounts;
    }
}
