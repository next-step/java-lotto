package lotto.model;

import java.util.Arrays;

public enum LottoLevels {

    BOOM(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int prizeMoney;

    LottoLevels(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoLevels match(int matchCount) {
        return Arrays.stream(LottoLevels.values())
                .filter(level -> level.matchCount == matchCount)
                .findFirst()
                .orElse(BOOM);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
