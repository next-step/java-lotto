package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private int matchCount;
    private boolean bonusMatch;
    private int winMoney;

    Rank(int matchCount, boolean bonusMatch, int winMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winMoney = winMoney;
    }

    public static Rank findByMatchCountAndBonusMatch(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusMatch == bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

    public int getWinMoney() {
        return winMoney;
    }

}
