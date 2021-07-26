package lotto.domain;

import java.util.Arrays;

public enum LottoMatchType {

    MISS(0,0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    LottoMatchType(int matchCount, int winMoney) {
        this.matchCount = matchCount;
        this.winMoney = winMoney;
    }

    private final int matchCount;
    private final int winMoney;

    public int getWinMoney() {
        return winMoney;
    }

    public static LottoMatchType findMatchCount(int count) {
        return Arrays.stream(values())
                .filter(f -> f.matchCount == count)
                .findFirst()
                .orElse(MISS);
    }
}
