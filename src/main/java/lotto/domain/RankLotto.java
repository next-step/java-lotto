package lotto.domain;

import java.util.Arrays;

public enum RankLotto {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningMoney;

    RankLotto(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static RankLotto findRank(int matchCount) {
        return Arrays.stream(RankLotto.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    int matchCount() {
        return matchCount;
    }

    int winningMoney() {
        return winningMoney;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, winningMoney);
    }
}
