package lotto.domain;

import lotto.util.Money;
import lotto.util.number.MultiplicationNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    LAST_PLACE  (new Money(0)),
    FOUR_PLACE  (3, new Money(5000)),
    THREE_PLACE (4, new Money(50000)),
    SECOND_PLACE(5, new Money(1500000)),
    FIRST_PLACE (6, new Money(2000000000));

    private final int matchesCount;
    private final Money prizeAmount;

    private static final String TO_STRING_FORMAT = "%s개 일치 (%s원)";

    LottoRank(Money prizeAmount) {
        this(-1, prizeAmount);
    }

    LottoRank(int matchesCount, Money prizeAmount) {
        this.matchesCount = matchesCount;
        this.prizeAmount = prizeAmount;
    }

    public Money prizeAmount(Number lottoSize) {
        return new Money(
                new MultiplicationNumber(prizeAmount, lottoSize)
        );
    }

    public static LottoRank of(int matchesCount) {
        return Arrays.stream(values()).filter(
                iLottoRank -> iLottoRank.matchesCount == matchesCount
        ).findFirst().orElse(LAST_PLACE);
    }

    public static List<LottoRank> displayRanks() {
        return Arrays.stream(values())
                .filter(iLottoRank -> iLottoRank.matchesCount > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,
                this.matchesCount, this.prizeAmount
        );
    }
}
