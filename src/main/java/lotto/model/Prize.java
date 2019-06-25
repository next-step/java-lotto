package lotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, false, Money.won(2_000_000_000)),
    SECOND(5, true, Money.won(30_000_000)),
    THIRD(5, false, Money.won(1_500_000)),
    FOURTH(4, false, Money.won(50_000)),
    FIFTH(3, false, Money.won(5_000)),
    NONE(0, false, Money.ZERO);

    private final int matchCount;
    private final boolean existBonus;
    private final Money money;

    Prize(int matchCount, boolean existBonus, Money money) {
        this.matchCount = matchCount;
        this.existBonus = existBonus;
        this.money = money;
    }

    static Prize of(int matchCount, boolean existBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatchPrize(matchCount, existBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatchPrize(int matchCount, boolean existBonus) {
        return isMatchCount(matchCount) && hasBonus(existBonus);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean hasBonus(boolean existBonus) {
        return this.existBonus == existBonus;
    }
}