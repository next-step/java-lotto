package lottery.domain;

public enum LotteryRanks {
    FIRST_PRIZE(2_000_000_000),
    SECOND_PRIZE(1_500_000),
    THIRD_PRIZE(50_000),
    FOURTH_PRIZE(5_000);

    private final int prizeMoney;

    private LotteryRanks(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
