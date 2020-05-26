package lottery.domain;

public enum LotteryRanks {
    FIRST_PRIZE("first", 2_000_000_000),
    SECOND_PRIZE("second", 1_500_000),
    THIRD_PRIZE("third", 50_000),
    FOURTH_PRIZE("fourth",5_000);

    private final String key;
    private final long prizeMoney;

    private LotteryRanks(String key, long prizeMoney) {
        this.key = key;
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
