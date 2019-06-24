package lotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIVE(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final long money;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize of(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize1 -> prize1.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
