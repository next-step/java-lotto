package lotto.step2.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OTHER(0, 0);

    private final int matchingCount;
    private final int prizeMoney;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank findByCount(final int count) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchingCount() == count)
                .findFirst()
                .orElse(OTHER);
    }
}
