package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3,5_000);

    private final int matchNumberCounts;
    private final long prizeMoney;

    private LotteryRank(int matchNumberCounts, long prizeMoney) {
        this.matchNumberCounts = matchNumberCounts;
        this.prizeMoney = prizeMoney;
    }

    public static LotteryRank valueOf(int matchNumberCounts) {
        return Arrays.stream(LotteryRank.values())
                .filter(lotteryRank -> lotteryRank.getMatchNumberCounts() == matchNumberCounts)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumberCounts() {
        return matchNumberCounts;
    }
}
