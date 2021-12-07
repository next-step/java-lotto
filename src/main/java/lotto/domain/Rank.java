package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.matchCount = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.asList(values()).stream()
                .filter(matchRank -> isEqualMatchCount(matchCount, matchRank))
                .findFirst()
                .orElse(null);
    }

    private static boolean isEqualMatchCount(int matchCount, Rank matchRank) {
        return matchRank.matchCount == matchCount;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + matchCount +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
