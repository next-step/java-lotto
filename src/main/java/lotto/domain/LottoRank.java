package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    ETC(0, 0, false);

    private final int matchCount;
    private final int winningPrize;
    private final boolean hasBonusNumber;

    LottoRank(int matchCount, int winningPrize, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
        this.hasBonusNumber = hasBonusNumber;
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