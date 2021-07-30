package lotto.domain;

import lotto.util.number.MultiplicationNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    LAST_PLACE  (new Money(0)),
    FOUR_PLACE  (3, new Money(5_000)),
    THREE_PLACE (4, new Money(5_0000)),
    SECOND_PLACE(5, new Money(1_500_000)),
    FIRST_PLACE (6, new Money(2_000_000_000));

    private final int matchesCount;
    private final Money prizeAmount;

    LottoRank(Money prizeAmount) {
        this(-1, prizeAmount);
    }

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
}
