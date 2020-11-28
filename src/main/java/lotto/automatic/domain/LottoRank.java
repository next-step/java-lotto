package lotto.automatic.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 200_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    NONE(0, 0);

    public final int matchCount;
    public final int earningMoney;

    LottoRank(int matchCount, int earningMoney) {
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
