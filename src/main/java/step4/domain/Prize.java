package step4.domain;

import java.util.Arrays;

public enum Prize {
    THREE_PRIZE(3, 5_000),
    FOUR_PRIZE(4, 50_000),
    FIVE_PRIZE(5, 1_500_000),
    FIVE_BONUS_PRIZE(5, 30_000_000),
    SIX_PRIZE(6, 2_000_000_000),
    NONE(0, 0);

    private final int count;
    final int prizeMoney;


    Prize(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    static Prize getPrize(int count, boolean isBonus) {
        return Arrays.stream(Prize.values())
                .filter(it-> isFilter(it, count, isBonus))
                .findFirst()
                .orElse(Prize.NONE);
    }

    private static boolean isFilter(Prize prize, int count, boolean isBonus) {
        return prize.count == count
                && ((!isBonus && prize != Prize.FIVE_BONUS_PRIZE) || (isBonus && prize == Prize.FIVE_BONUS_PRIZE));
    }
}
