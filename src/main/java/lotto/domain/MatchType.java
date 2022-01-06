package lotto.domain;

import java.util.Arrays;

public enum MatchType {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS_BALL(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int money;

    MatchType(final int count, final int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static MatchType[] matchType() {
        return values();
    }

    public static MatchType of(final int count, boolean matchBonusBall) {
        if (count == 5 && matchBonusBall) {
            return FIVE_AND_BONUS_BALL;
        }

        return Arrays.stream(values())
            .filter(value -> value.getCount() == count)
            .findFirst()
            .orElseThrow(IllegalStateException::new);

    }


}
