package lotto.domain;

import java.util.Arrays;

public enum WinningType {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int value;
    private final int profit;

    WinningType(int value, int profit) {
        this.value = value;
        this.profit = profit;
    }

    public static WinningType match(int count, boolean isBonusBall) {
        if (FIVE.isEqualCount(count) && isBonusBall) return FIVE_BONUS;

        return Arrays.stream(WinningType.values())
                .filter(lottoCorrectCount -> lottoCorrectCount.isEqualCount(count))
                .findFirst().orElse(NONE);
    }

    public boolean isEqualCount(int count) {
        return value == count;
    }

    public int getValue() {
        return value;
    }

    public int getProfit() {
        return profit;
    }
}
