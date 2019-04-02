package lotto.domain;

import java.util.Arrays;

public enum WinningOrder {
    FIRST_PLACE(Money.from(2_000_000_000), (howManyMatches, bonusContains) -> howManyMatches == 6),
    SECOND_PLACE(Money.from(30_000_000), (howManyMatches, bonusContains) -> howManyMatches == 5 && bonusContains),
    THIRD_PLACE(Money.from(150_000), (howManyMatches, bonusContains) -> howManyMatches == 5),
    FOURTH_PLACE(Money.from(50_000), (howManyMatches, bonusContains) -> howManyMatches == 4),
    FIFTH_PLACE(Money.from(5_000), (howManyMatches, bonusContains) -> howManyMatches == 3),
    LAST_PLACE(Money.ZERO, (howManyMatches, bonusContains) -> false);

    private final Money amount;
    private final WinningStrategy condition;

    WinningOrder(final Money amount, final WinningStrategy condition) {
        this.amount = amount;
        this.condition = condition;
    }

    public static WinningOrder from(final long howManyMatches, final boolean bonusContains) {
        return Arrays.stream(WinningOrder.values())
                .filter(winningOrder -> winningOrder.condition.winnable(howManyMatches, bonusContains))
                .findAny()
                .orElse(WinningOrder.LAST_PLACE)
                ;
    }

    public Money getAmount() {
        return amount;
    }
}
