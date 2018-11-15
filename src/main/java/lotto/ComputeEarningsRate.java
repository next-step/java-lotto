package lotto;

import java.util.Map;

public class ComputeEarningsRate {
    public static final double DEFAULT_VALUE = 0.0;
    public static final int INT_DEFAULT_VALUE = 0;

    public static double computeEarningRate(double earnings, double price) {
        return earnings == DEFAULT_VALUE ? DEFAULT_VALUE : (earnings / price);
    }

    public static double computeEarning(Map<LottoType, Integer> winnings, double earnings) {
        for (LottoType lottoType : LottoType.values()) {
            int winningCount = winnings.getOrDefault(lottoType, INT_DEFAULT_VALUE);
            earnings += lottoType.computeEarning(winningCount);
        }
        return earnings;
    }
}
