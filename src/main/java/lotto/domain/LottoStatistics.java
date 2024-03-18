package lotto.domain;

import java.util.*;

public enum LottoStatistics {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;

    private final int matchCount;
    private final int winAmount;

    LottoStatistics(int matchCount, int winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    private static final Map<Integer, Integer> matchAmountMap = new HashMap<>();
    static {
        for (LottoStatistics statistic : LottoStatistics.values()) {
            matchAmountMap.put(statistic.matchCount, statistic.winAmount);
        }
    }

    private static final List<Integer> matchCounts = new ArrayList<>();
    static {
        for (LottoStatistics statistic : LottoStatistics.values()) {
            matchCounts.add(statistic.matchCount);
        }
        Collections.sort(matchCounts);
    }

    public static List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public static int getWinAmount(int matchCount) {
        return matchAmountMap.get(matchCount);
    }

    public static Map<Integer, Integer> getLottoStatisticsMap(LottoTickets lottoTickets, List<Integer> winNumbers) {
        Map<Integer, Integer> statisticMap = initStatisticsMap();
        for (LottoTicket lottoTicket : lottoTickets.get()) {
            int matchCount = lottoTicket.matchNumbers(winNumbers);
            addStatistic(statisticMap, matchCount);
        }

        return statisticMap;
    }

    private static Map<Integer, Integer> initStatisticsMap() {
        Map<Integer, Integer> statisticMap = new HashMap<>();
        for (int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++) {
            statisticMap.put(matchCount, 0);
        }
        return statisticMap;
    }

    private static void addStatistic(Map<Integer, Integer> statisticMap, int matchCount) {
        if (isExistMatchCount(matchCount)) {
            statisticMap.put(matchCount, statisticMap.getOrDefault(matchCount, 0) + 1);
        }
    }

    public static double calculateProfitRate(Map<Integer, Integer> statisticsMap, int purchaseAmount) {
        double totalProfit = 0;
        for (Integer matchCount : statisticsMap.keySet()) {
            totalProfit += getProfitByMatchCount(statisticsMap, matchCount);
        }
        return totalProfit / purchaseAmount;
    }

    private static double getProfitByMatchCount(Map<Integer, Integer> statisticsMap, Integer matchCount) {
        if (isExistMatchCount(matchCount)) {
            return statisticsMap.get(matchCount) * getWinAmount(matchCount);
        }
        return 0;
    }

    private static boolean isExistMatchCount(Integer matchCount) {
        return matchAmountMap.get(matchCount) != null;
    }

}
