package lotto.domain;

import java.util.Arrays;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int prizes;

    LottoRank(int matchCount, int prizes) {
        this.matchCount = matchCount;
        this.prizes = prizes;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizes() {
        return prizes;
    }

    public static LottoRank match(long matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}
