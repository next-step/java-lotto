package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchedNumber;
    private final int winningPrice;
    private final boolean requiresBonusMatch;

    LottoRank(final int matchedNumber, final int winningPrice, final boolean requiresBonusMatch) {
        this.matchedNumber = matchedNumber;
        this.winningPrice = winningPrice;
        this.requiresBonusMatch = requiresBonusMatch;
    }

    public static LottoRank findLottoRankByMatchedNumber(final int matchedNumber) {
        return findLottoRankByMatchedNumber(matchedNumber, false);
    }

    public static LottoRank findLottoRankByMatchedNumber(final int matchedNumber, final boolean isMatchedBonusNumber) {
        return Arrays.stream(values())
            .filter(value -> value.matchedNumber == matchedNumber)
            .filter(rank -> !rank.requiresBonusMatch || isMatchedBonusNumber)
            .findFirst()
            .orElse(NONE);
    }

    public long calculateWinningPrice(final int winningLottoCount) {
        return (long) winningPrice * winningLottoCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
