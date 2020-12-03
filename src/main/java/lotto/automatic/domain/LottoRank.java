package lotto.automatic.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 200_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int earningMoney;

    LottoRank(int matchCount, int earningMoney) {
        this.matchCount = matchCount;
        this.earningMoney = earningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getEarningMoney() {
        return earningMoney;
    }

    public static LottoRank match(int matchCount, boolean matchBonus) {

        if(matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.MISS);

    }

}
