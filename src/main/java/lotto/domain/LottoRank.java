package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NO_RANK(0, 0);

    private int matchedCount;
    private int prizeMoney;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchedCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findByMatchedCount(int count) {
        return Arrays.stream(LottoRank.values())
                .filter(lotteRank -> lotteRank.matchedCount == count)
                .findAny()
                .orElse(LottoRank.NO_RANK);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}

