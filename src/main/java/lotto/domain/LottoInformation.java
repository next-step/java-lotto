package lotto.domain;

import java.util.*;

public enum LottoInformation {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    private final int matchCount;
    private final int winAmount;

    LottoInformation(int matchCount, int winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    private static final Map<Integer, Integer> matchAmountMap = new HashMap<>();
    static {
        for (LottoInformation information : LottoInformation.values()) {
            matchAmountMap.put(information.matchCount, information.winAmount);
        }
    }

    private static final List<Integer> matchCounts = new ArrayList<>();
    static {
        for (LottoInformation information : LottoInformation.values()) {
            matchCounts.add(information.matchCount);
        }
        Collections.sort(matchCounts);
    }

    public static List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public static int getWinAmount(int matchCount) {
        return matchAmountMap.get(matchCount);
    }

    public static double calculateProfitRate(LottoStatistics statisticsMap, int purchaseAmount) {
        double totalProfit = 0;
        for (Integer matchCount : statisticsMap.keySet()) {
            totalProfit += getProfitByMatchCount(statisticsMap, matchCount);
        }
        return totalProfit / purchaseAmount;
    }

    private static double getProfitByMatchCount(LottoStatistics statisticsMap, Integer matchCount) {
        if (isExistMatchCount(matchCount)) {
            return statisticsMap.getMatchedLottoCount(matchCount) * getWinAmount(matchCount);
        }
        return 0;
    }

    public static boolean isExistMatchCount(Integer matchCount) {
        return matchAmountMap.get(matchCount) != null;
    }

}
