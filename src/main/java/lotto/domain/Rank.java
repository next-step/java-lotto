package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    static Rank of(int matchCount, boolean isMatchedBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .filter(rank -> !rank.equals(Rank.SECOND) || isMatchedBonusNumber)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public static int getMoneyByMatchCount(int matchCount, boolean isMatchedBonus) {
        return Rank.of(matchCount, isMatchedBonus).getMoney();
    }

    public int addMoney(int totalMoney) {
        return totalMoney + money;
    }

    public boolean isSameMatchCount(int matchCount) {
        return matchCount == this.matchCount;
    }

    public int getMoney() {
        return this.money;
    }
}
