package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class WinningStatistics {

    public WinningStatistics() {
        winningStatistic = setWinningStatistics();
    }

    public static LinkedHashMap<LottoPrizeType, Integer> winningStatistic = setWinningStatistics();

    public static LinkedHashMap<LottoPrizeType, Integer> setWinningStatistics() {
        winningStatistic = new LinkedHashMap<>();
        for (LottoPrizeType lottoPrizeType : LottoPrizeType.values()) {
            winningStatistic.put(lottoPrizeType, 0);
        }
        return winningStatistic;
    }

    public static HashMap<LottoPrizeType, Integer> getWinningStatistic() {
        return winningStatistic;
    }


    public static int addCount(Optional<LottoPrizeType> lottoPrizeTypeOptional) {
        if (!lottoPrizeTypeOptional.isPresent()) {
            return 0;
        }
        LottoPrizeType lottoPrizeType = lottoPrizeTypeOptional.get();
        int increaseCount = winningStatistic.get(lottoPrizeType) + 1;
        winningStatistic.put(lottoPrizeType, increaseCount);
        return increaseCount;
    }

    public static double calcLottoYield(int purchaseAmount) {
        return getWinningAmount() / purchaseAmount;
    }

    private static double getWinningAmount() {
        double winningAmount = 0;
        for (LottoPrizeType lottoPrizeType : winningStatistic.keySet()) {
            winningAmount += lottoPrizeType.getWinningAmount() * winningStatistic.get(lottoPrizeType);
        }

        return winningAmount;
    }
}
