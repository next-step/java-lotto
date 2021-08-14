package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class WinningStatistics {

    LinkedHashMap<LottoPrizeType, Integer> winningStatistic;

    public WinningStatistics() {
        winningStatistic = new LinkedHashMap<>();
        for (LottoPrizeType lottoPrizeType : LottoPrizeType.values()) {
            winningStatistic.put(lottoPrizeType, 0);
        }
    }

    public HashMap<LottoPrizeType, Integer> getWinningStatistic() {
        return winningStatistic;
    }


    public int addCount(LottoPrizeType lottoPrizeType) {
        if (lottoPrizeType == null) {
            return 0;
        }
        int increaseCount = winningStatistic.get(lottoPrizeType) + 1;
        winningStatistic.put(lottoPrizeType, increaseCount);
        return increaseCount;
    }

    public double calcLottoYield(int purchaseAmount) {
        return getWinningAmount() / purchaseAmount;
    }

    private double getWinningAmount() {
        double winningAmount = 0;
        for (LottoPrizeType lottoPrizeType : winningStatistic.keySet()) {
            winningAmount += lottoPrizeType.getWinningAmount() * winningStatistic.get(lottoPrizeType);
        }

        return winningAmount;
    }
}
