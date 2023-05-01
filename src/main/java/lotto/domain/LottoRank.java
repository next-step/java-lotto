package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOf(int count, boolean matchBonus) {
        if (count == 5 && matchBonus) {
            return SECOND;
        }

        if (count == 5) {
            return THIRD;
        }

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

    public boolean isSecond() {
        return this == LottoRank.SECOND;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
