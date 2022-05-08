package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NO_MATCH(0, 0);


    private final int matchCount;
    private final int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
              .filter(rank -> rank.isSameMatchCount(matchCount))
              .findFirst()
              .orElse(NO_MATCH);
    }

    public static int getMoneyByMatchCount(int matchCount) {
        return Rank.of(matchCount).getMoney();
    }

    public int addMoney(int totalMoney) {
        return totalMoney + money;
    }

    public boolean isSameMatchCount(int matchCount) {
        return matchCount == this.matchCount;
    }

    public int getMoney(){
        return this.money;
    }
}
