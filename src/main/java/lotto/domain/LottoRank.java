package lotto.domain;

import lotto.util.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PLACE (1, 6, new Money(2000000000)),
    SECOND_PLACE(2, 5, new Money(1500000)),
    THREE_PLACE (3, 4, new Money(50000)),
    FOUR_PLACE  (4, 3, new Money(5000)),
    LAST_PLACE  (5, 2, new Money(0));

    private final int ranking;
    private final int matchesCount;
    private final Money prizeAmount;

    LottoRank(int ranking, int matchesCount, Money prizeAmount) {
        this.ranking = ranking;
        this.matchesCount = matchesCount;
        this.prizeAmount = prizeAmount;
    }

    public Money prizeAmount() {
        return prizeAmount;
    }

    public Money prizeAmount(Number count) {
        return prizeAmount(count.intValue());
    }

    public Money prizeAmount(int count) {
        return prizeAmount.multiply(count);
    }

    public static LottoRank of(int matchesCount) {
        return Arrays.stream(values()).filter(
                iLottoRank -> iLottoRank.matchesCount == matchesCount
        ).findFirst().orElse(LAST_PLACE);
    }
}
