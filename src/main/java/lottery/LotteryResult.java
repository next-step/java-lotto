package lottery;

import java.util.EnumMap;

public class LotteryResult {

    private final EnumMap<LotteryRank, Integer> winningCounts;
    private final int lotteryPrice;

    public LotteryResult(EnumMap<LotteryRank, Integer> winningCounts, int lotteryPrice) {
        this.winningCounts = winningCounts;
        this.lotteryPrice = lotteryPrice;
    }

    public int getWinningCountOfRank(LotteryRank lotteryRank) {
        return winningCounts.getOrDefault(lotteryRank, 0);
    }

    public double getReturnRate() {
        return getTotalPrizes() / (getTotalPurchaseAmount() * lotteryPrice);
    }

    private double getTotalPrizes() {
        return winningCounts.keySet().stream()
                .mapToDouble(lotteryRank -> lotteryRank.getPrize() * getWinningCountOfRank(lotteryRank))
                .sum();
    }

    private int getTotalPurchaseAmount() {
        return winningCounts.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
