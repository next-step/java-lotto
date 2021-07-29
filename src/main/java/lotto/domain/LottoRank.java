package lotto.domain;

import lotto.util.Money;
import lotto.util.number.MultiplicationNumber;

import java.util.Arrays;

public enum LottoRank {
    LAST_PLACE  (2, new Money(0)),
    FOUR_PLACE  (3, new Money(5000)),
    THREE_PLACE (4, new Money(50000)),
    SECOND_PLACE(5, new Money(1500000)),
    FIRST_PLACE (6, new Money(2000000000));

    private final int matchesCount;
    private final Money prizeAmount;

    LottoRank(int matchesCount, Money prizeAmount) {
        this.matchesCount = matchesCount;
        this.prizeAmount = prizeAmount;
    }

    public int matchesCount() {
        return matchesCount;
    }

    public Money prizeAmount() {
        return prizeAmount;
    }

    public Money prizeAmount(Number count) {
        return new Money(
                new MultiplicationNumber(prizeAmount, count)
        );
    }

    public static LottoRank of(int matchesCount) {
        return Arrays.stream(values()).filter(
                iLottoRank -> iLottoRank.matchesCount == matchesCount
        ).findFirst().orElse(LAST_PLACE);
    }
}
