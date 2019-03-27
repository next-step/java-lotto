package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NO_PRIZE(0, 0, false);

    private final int numberOfMatch;
    private final int prizeMoney;
    private final boolean isMatchingBonus;

    Prize(int numberOfMatch, int prizeMoney, boolean isMatchingBonus) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
        this.isMatchingBonus = isMatchingBonus;
    }

    public static Prize valueOf(int numberOfMatch, boolean isMatchingBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.isEqual(numberOfMatch, isMatchingBonus))
                .findFirst()
                .orElse(NO_PRIZE);
    }

    private boolean isEqual(int numberOfMatch, boolean isMatchingBonus) {
        if (numberOfMatch == Prize.SECOND_PRIZE.numberOfMatch) {
            return this.numberOfMatch == numberOfMatch && this.isMatchingBonus == isMatchingBonus;
        }
        return this.numberOfMatch == numberOfMatch;
    }

    public int calculatePrizeMoneyBy(int count) {
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

