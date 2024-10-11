package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
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
        return findLottoRankByMatchedNumber(matchedNumber, false);
    }

    public static LottoRank findLottoRankByMatchedNumber(final int matchedNumber, final boolean isMatchedBonusNumber) {
        return Arrays.stream(values())
            .filter(value -> value.matchedNumber == matchedNumber)
            .sorted(Comparator.comparingInt(LottoRank::getWinningPrice))
            .map(rank -> adjustRankWithBonus(rank, isMatchedBonusNumber))
            .findAny()
            .orElse(NONE);
    }

    private static LottoRank adjustRankWithBonus(final LottoRank lottoRank, final boolean isMatchedBonusNumber) {
        if (THIRD.equals(lottoRank) && isMatchedBonusNumber) {
            return SECOND;
        }
        return lottoRank;
    }

    public long calculateWinningPrice(final int winningLottoCount) {
        return (long) winningPrice * winningLottoCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
