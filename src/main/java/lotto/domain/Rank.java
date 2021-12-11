package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private int matchCount;
    private int winningMoney;
    private String statisticsMessage;

    Rank(int countOfMatch, int winningMoney, String statisticsMessage) {
        this.matchCount = countOfMatch;
        this.winningMoney = winningMoney;
        this.statisticsMessage = statisticsMessage;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if(isEqualMatchCount(matchCount, SECOND) && matchBonus){
            return Rank.SECOND;
        }

        return Stream.of(values())
                .filter(matchRank -> isEqualMatchCount(matchCount, matchRank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isEqualMatchCount(int matchCount, Rank matchRank) {
        return matchRank.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getStatisticsMessage() {
        return statisticsMessage;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + matchCount +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
