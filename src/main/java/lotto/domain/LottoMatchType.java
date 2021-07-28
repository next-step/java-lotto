package lotto.domain;

import java.util.Arrays;

public enum LottoMatchType {

    MISS(0, 0, ""),
    FIFTH(3, 5_000, ""),
    FOURTH(4, 50_000, ""),
    THIRD(5, 1_500_000, ""),
    SECOND(5, 30_000_000, ", 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "");

    LottoMatchType(int matchCount, int winMoney, String description) {
        this.matchCount = matchCount;
        this.winMoney = winMoney;
        this.description = description;
    }

    private final int matchCount;
    private final int winMoney;
    private final String description;

    public int getWinMoney() {
        return winMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public static LottoMatchType findMatchCount(int count, boolean matchBonus) {
        if (matchBonus && SECOND.matchCount == count) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(f -> findMatchType(f, count))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean findMatchType(LottoMatchType f, int count) {
        return f.matchCount == count && f != SECOND;
    }
}
