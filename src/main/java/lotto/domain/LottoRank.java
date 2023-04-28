package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int count) {
        return Arrays.stream(values())
                .filter(e -> e.matchCount == count)
                .findFirst()
                .orElse(FAIL);
    }

    public int calculatePrizeMoney(int count) {
        return count * prizeMoney;
    }

    public boolean isMiss() {
        return matchCount == 0;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
