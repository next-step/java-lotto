package lotto.domain;

import java.util.Arrays;

public enum WinningOrder {
    FIRST_PLACE(Money.from(2_000_000_000), 6),
    SECOND_PLACE(Money.from(150_000), 5),
    THIRD_PLACE(Money.from(50_000), 4),
    FOURTH_PLACE(Money.from(5_000), 3),
    LAST_PLACE(Money.ZERO, 0);

    private final Money amount;
    private final int condition;

    WinningOrder(final Money amount, final int condition) {
        this.amount = amount;
        this.condition = condition;
    }

    public static WinningOrder from(final long howManyMatches) {
        return Arrays.stream(WinningOrder.values())
                .filter(winningOrder -> winningOrder.condition == howManyMatches)
                .findAny()
                .orElse(WinningOrder.LAST_PLACE)
                ;
    }

    public Money getAmount() {
        return amount;
    }

    public int getCondition() {
        return condition;
    }
}
