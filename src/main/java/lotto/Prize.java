package lotto;

public enum Prize {
    NO_PRIZE(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int numberOfMatch;
    private final long prizeMoney;

    Prize(int numberOfMatch, long prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Prize fromNumberOfMatch(int numberOfMatch) {
        for (Prize prize : values()) {
            if (prize.numberOfMatch == numberOfMatch) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    public long calculatePrizeMoneyBy(int count) {
        return count * prizeMoney;
    }

    @Override
    public String toString() {
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)-";
    }
}

