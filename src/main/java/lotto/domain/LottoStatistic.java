package lotto.domain;

import java.util.*;

public enum LottoStatistic {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    private final int matchCount;
    private final int winningAmount;

    LottoStatistic(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    private static final Map<Integer, Integer> statisticMap = new HashMap<>();
    static {
        for (LottoStatistic statistic : LottoStatistic.values()) {
            statisticMap.put(statistic.matchCount, statistic.winningAmount);
        }
    }

    private static final List<Integer> matchCounts = new ArrayList<>();
    static {
        for (LottoStatistic statistic : LottoStatistic.values()) {
            matchCounts.add(statistic.matchCount);
        }
        Collections.sort(matchCounts);
    }

    public static List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public static int getWinningAmount(int matchCount) {
        return statisticMap.get(matchCount);
    }

}
