package lotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final long money;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize of(int matchCount, boolean existBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatchPrize(matchCount, existBonus))
                .findFirst()
                .orElse(Prize.NONE);
    }

    private boolean isMatchPrize(int matchCount, boolean existBonus) {
        if (this == SECOND) {
            return this.getMatchCount() == matchCount && existBonus;
        }
        return this.getMatchCount() == matchCount;
    }

    public long getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
