package lotto.domain;

import lotto.util.Money;

public enum LottoRank {
    FIRST_PLACE (1, new Money(2000000000)),
    SECOND_PLACE(2, new Money(1500000)),
    THREE_PLACE (3, new Money(50000)),
    FOUR_PLACE  (4, new Money(5000));

    private final int ranking;
    private final Money prizeAmount;

    LottoRank(int ranking, Money prizeAmount) {
        this.ranking = ranking;
        this.prizeAmount = prizeAmount;
    }

    public Money prizeAmount() {
        return prizeAmount;
    }

    public Money prizeAmount(int count) {
        return prizeAmount.multiply(count);
    }
}
