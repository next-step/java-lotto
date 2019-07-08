package lotto.domain;

import java.util.Arrays;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int prizes;

    LottoRank(int matchCount, int prizes) {
        this.matchCount = matchCount;
        this.prizes = prizes;
    }

    public boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizes() {
        return prizes;
    }

    public static LottoRank of(int matchCount, boolean hasMatchBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isSameMatchCount(matchCount))
                .filter(lottoRank -> isMatchSecond(hasMatchBonusNumber, lottoRank))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isMatchSecond(boolean hasMatchBonusNumber, LottoRank lottoRank) {
        return !lottoRank.equals(SECOND) || hasMatchBonusNumber;
    }
}
