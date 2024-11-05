package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ETC(0,false, 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int winningPrize;

    LottoRank(int matchCount, boolean hasBonusNumber, int winningPrize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrize = winningPrize;
    }

    public static LottoRank findRankByMatchCount(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.hasBonusNumber == hasBonusNumber && lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(ETC);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}