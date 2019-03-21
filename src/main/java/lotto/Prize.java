package lotto;

public enum Prize {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NO_PRIZE(0, 0);

    private final int numberOfMatch;
    private final long prizeMoney;

    Prize(int numberOfMatch, long prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Prize fromNumberOfMatch(int numberOfMatch, boolean isMatchingBonus) {
        for (Prize prize : values()) {
            if (prize.numberOfMatch == numberOfMatch) {
                return fromBonusMatch(prize, isMatchingBonus);
            }
        }
        return NO_PRIZE;
    }

    private static Prize fromBonusMatch(Prize prize, boolean isMatchingBonus) {
        if (prize == SECOND_PRIZE) {
            return isMatchingBonus ? SECOND_PRIZE : THIRD_PRIZE;
        }
        return prize;
    }

    public long calculatePrizeMoneyBy(int count) {
        return count * prizeMoney;
    }

    @Override
    public String toString() {
        if(this == SECOND_PRIZE) {
            return numberOfMatch + "개 일치, 보너스 볼 일치(" + prizeMoney + "원)-";
        }
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)-";
    }
}

