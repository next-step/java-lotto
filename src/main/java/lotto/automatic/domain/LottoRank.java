package lotto.automatic.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 200000000L),
    SECOND(5, 1500000L),
    THIRD(4, 50000L),
    FORTH(3, 5000L),
    NONE(0, 0L);

    public final int matchCount;
    public final long earningMoney;

    LottoRank(int matchCount, long earningMoney) {
        this.matchCount = matchCount;
        this.earningMoney = earningMoney;
    }

    public static LottoRank matchCount(int matchCount) {

        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.NONE);

    }

}
