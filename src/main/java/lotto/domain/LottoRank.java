package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoRank {
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        ETC(0,false, 0);

    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;
    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int winningPrize;

    LottoRank(int matchCount, boolean hasBonusNumber, int winningPrize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrize = winningPrize;
    }

    public static LottoRank findRankByMatchCount(int matchCount, boolean hasBonusNumber) {
        if (matchCount < MIN_MATCH_COUNT || matchCount > MAX_MATCH_COUNT) {
            throw new IllegalArgumentException("유효한 개수가 아닙니다.");
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.hasBonusNumber == hasBonusNumber && lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.ETC);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}