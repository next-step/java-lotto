package lotto.domain;

import lotto.util.number.MultiplicationNumber;

import java.util.Arrays;

public enum LottoRank {
    LAST_PLACE(0, new Money(0)),
    FIVE_PLACE(3, new Money(5_000)),
    FOUR_PLACE(4, new Money(5_0000)),
    THREE_PLACE(5, new Money(1_500_000)),
    SECOND_PLACE(5, new Money(30_000_000)),
    FIRST_PLACE(6, new Money(2_000_000_000));

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

    public Money prizeAmount(Number lottoSize) {
        return new Money(
                new MultiplicationNumber(prizeAmount, lottoSize)
        );
    }

    private boolean isSecondPlace(boolean includeBonusNumber) {
        if (this != THREE_PLACE)
            return false;
        return includeBonusNumber;
    }

    public static LottoRank of(int matchesCount, boolean includeBonusNumber) {
        LottoRank rank = Arrays.stream(values())
                .filter(iLottoRank ->
                        iLottoRank.matchesCount() == matchesCount
                ).findFirst().orElse(LAST_PLACE);
        return rank.isSecondPlace(includeBonusNumber) ? SECOND_PLACE : rank;
    }
}
