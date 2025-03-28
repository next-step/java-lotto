package step3.lotto.model;

import java.util.Map;

public enum LottoPrize {

    FIRST(new Count(6)),
    THIRD(new Count(5)),
    FOURTH(new Count(4)),
    FIFTH(new Count(3));

    private final Count count;

    LottoPrize(Count count) {
        this.count = count;
    }

    private static final Map<Count, Money> PRIZE_MONEY = Map.of(
        FIRST.count, new Money(2_000_000_000L),
        THIRD.count, new Money(1_500_000L),
        FOURTH.count, new Money(50_000L),
        FIFTH.count, new Money(5_000L)
    );

    public static Money moneyOf(Count count) {
        return PRIZE_MONEY.get(count);
    }

}
