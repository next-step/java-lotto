package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOT_MATCH(0, 0),
    FOUR(3, 5000) ,
    THIRD(4, 50000) ,
    SECOND(5, 1500000) ,
    FIRST(6, 2000000000);

    private final Integer matchCount;
    private final Integer winningMoney;

    Rank(Integer matchCount, Integer winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank findRank(Integer matchCount) {
        return Arrays.stream(Rank.values())
                .filter(type -> type.matchCount != null)
                .filter(type -> matchCount.equals(type.matchCount))
                .findFirst()
                .orElse(NOT_MATCH);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }
}
