package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchingCount;
    private final int money;
    private final boolean matchingBonus;

    Prize( int matchingCount, int prizeMoney, boolean matchingBonus) {
        this.matchingCount = matchingCount;
        this.money = prizeMoney;
        this.matchingBonus = matchingBonus;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int money() {
        return money;
    }

    int calculateWinningMoney(int count) {
        return money * count;
    }

    public static Prize valueOf(int matchingCount, boolean matchingBonus) {
        return Arrays.stream(values())
                .filter(p -> matchingCount == p.matchingCount && matchingBonus == p.matchingBonus)
                .findFirst()
                .orElse(NONE);
    }
}
