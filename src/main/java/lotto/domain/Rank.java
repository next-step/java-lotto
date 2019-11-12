package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    MISS(0, 0, false, 0);

    private int winOrder;
    private int matchCount;
    private boolean bonusMatch;
    private int winMoney;

    Rank(int winOrder, int matchCount, boolean bonusMatch, int winMoney) {
        this.winOrder = winOrder;
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

    public static Rank findByOrder(int order) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.ordinal() == order)
                .findFirst()
                .orElse(MISS);
    }

    public static int countRankType() {
        return (int) Arrays.stream(Rank.values())
                .count();
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinOrder() {
        return winOrder;
    }

}
