package lotto;

public enum Prize {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NO_PRIZE(0, 0, false);

    private final int numberOfMatch;
    private final long prizeMoney;
    private final boolean isMatchingBonus;

    Prize(int numberOfMatch, long prizeMoney, boolean isMatchingBonus) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
        this.isMatchingBonus = isMatchingBonus;
    }

    public static Prize valueOf(int numberOfMatch, boolean isMatchingBonus) {
        for (Prize prize : values()) {
            if (prize.isEqual(numberOfMatch, isMatchingBonus)) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    private boolean isEqual(int numberOfMatch, boolean isMatchingBonus) {
        if(numberOfMatch == Prize.SECOND_PRIZE.numberOfMatch) {
            return this.numberOfMatch == numberOfMatch && this.isMatchingBonus == isMatchingBonus;
        }
        return this.numberOfMatch == numberOfMatch;
    }

    public long calculatePrizeMoneyBy(int count) {
        return count * prizeMoney;
    }

    @Override
    public String toString() {
        if (this == SECOND_PRIZE) {
            return numberOfMatch + "개 일치, 보너스 볼 일치(" + prizeMoney + "원)-";
        }
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)-";
    }
}

