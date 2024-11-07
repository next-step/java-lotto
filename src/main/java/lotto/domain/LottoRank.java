package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoRank {
        FIRST(6, 2_000_000_000),
        SECOND(5, 30_000_000),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000),
        ETC(0,0);

    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;

    private final int matchCount;
    private final int winningPrize;

    LottoRank(int matchCount, int winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public static LottoRank findRankByMatchCount(int matchCount, boolean hasBonusNumber) {
        if (matchCount < MIN_MATCH_COUNT || matchCount > MAX_MATCH_COUNT) {
            throw new IllegalArgumentException("유효한 개수가 아닙니다.");
        }

        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }

        if (matchCount == THIRD.matchCount && !hasBonusNumber) {
            return THIRD;
        }

        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }

        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }

        if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }

        return ETC;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}