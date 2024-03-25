package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOT_MATCH(0, 0),
    FIVE(3, 5_000),
    FOUR(4, 50_000) ,
    THIRD(5,  1_500_000) ,
    SECOND(5, 30_000_000) ,
    FIRST(6, 2_000_000_000);

    private final Integer matchCount;
    private final Integer winningMoney;

    Rank(Integer matchCount, Integer winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(type -> matchCount == type.matchCount)
                .filter(rank -> rank != NOT_MATCH && rank != THIRD && rank != SECOND) // NOT_MATCH, THIRD, SECOND 빼고
                .findFirst()
                .orElseGet(() -> Arrays.stream(Rank.values())
                        .filter(rank -> matchCount == rank.matchCount)
                        .filter(rank -> !matchBonus && rank == THIRD || matchBonus && rank == SECOND) // matchBonus가 false이면 THIRD, true이면 SECOND
                        .findFirst()
                        .orElse(NOT_MATCH));
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }
}
