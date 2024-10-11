package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchedNumber;
    private final int winningPrice;

    LottoRank(final int matchedNumber, final int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.winningPrice = winningPrice;
    }

    public static LottoRank findLottoRankByMatchedNumber(final int matchedNumber) {
        return Arrays.stream(values())
            .filter(value -> value.matchedNumber == matchedNumber)
            .findAny()
            .orElse(NONE);
    }

    public long calculateWinningPrice(final int winningLottoCount) {
        return (long) winningPrice * winningLottoCount;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
