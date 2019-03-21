package lotto.domain;

import java.util.Arrays;

public enum WinningOrder {
    FIRST_PLACE(2_000_000_000, 6),
    SECOND_PLACE(150_000, 5),
    THIRD_PLACE(50_000, 4),
    FOURTH_PLACE(5_000, 3),
    LAST_PLACE(0, 0);

    private final long amount;
    private final int condition;

    WinningOrder(final int amount, final int condition) {
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

    public long getAmount() {
        return amount;
    }

    public int getCondition() {
        return condition;
    }
}
