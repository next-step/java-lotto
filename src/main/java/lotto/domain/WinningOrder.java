package lotto.domain;

import java.util.Arrays;

public enum WinningOrder {
    FIRST_PLACE(Money.from(2_000_000_000), (howManyMatches, bonusContains) -> howManyMatches == 6, "6개 일치"),
    SECOND_PLACE(Money.from(30_000_000), (howManyMatches, bonusContains) -> howManyMatches == 5 && bonusContains, "5개 일치, 보너스 볼 일치"),
    THIRD_PLACE(Money.from(150_000), (howManyMatches, bonusContains) -> howManyMatches == 5, "5개 일치"),
    FOURTH_PLACE(Money.from(50_000), (howManyMatches, bonusContains) -> howManyMatches == 4, "4개 일치"),
    FIFTH_PLACE(Money.from(5_000), (howManyMatches, bonusContains) -> howManyMatches == 3, "3개 일치"),
    LAST_PLACE(Money.ZERO, (howManyMatches, bonusContains) -> false, "");

    private final Money amount;
    private final WinningStrategy condition;
    private final String phrase;

    WinningOrder(final Money amount, final WinningStrategy condition, final String phrase) {
        this.amount = amount;
        this.condition = condition;
        this.phrase = phrase;
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

    public String getPhrase() {
        return phrase;
    }
}
