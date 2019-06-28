package lotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, Money.won(2_000_000_000)),
    SECOND(5, Money.won(30_000_000)),
    THIRD(5, Money.won(1_500_000)),
    FOURTH(4, Money.won(50_000)),
    FIFTH(3, Money.won(5_000)),
    NONE(0, Money.ZERO);

    private final int matchCount;
    private final Money money;

    Prize(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    static Prize of(int matchCount, boolean existBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatchCount(matchCount))
                .filter(prize -> prize.isSecond(existBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isSecond(boolean existBonus) {
        return this != SECOND || existBonus;
    }

    public Money getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }

}