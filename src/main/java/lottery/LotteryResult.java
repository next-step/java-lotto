package lottery;

import java.util.EnumMap;

import static lottery.LotteryRank.getInstanceOfRank;

public class LotteryResult {

    private final EnumMap<LotteryRank, Integer> winningCounts;

    private final int totalPurchaseAmount;
    private final int lotteryPrice;

    public LotteryResult(EnumMap<LotteryRank, Integer> winningCounts, int totalPurchaseAmount, int lotteryPrice) {
        this.winningCounts = winningCounts;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.lotteryPrice = lotteryPrice;
    }

    public int getWinningCountOfRank(int rank) {
        return winningCounts.getOrDefault(getInstanceOfRank(rank), 0);
    }

    public double getReturnRate() {
        double totalWonPrizes = 0.0;
        for (LotteryRank lotteryRank : winningCounts.keySet()) {
            int rank = LotteryRank.getRank(lotteryRank);
            totalWonPrizes += LotteryRank.getPrizeOfRank(rank) * getWinningCountOfRank(rank);
        }
        return totalWonPrizes / (totalPurchaseAmount * lotteryPrice);
    }

}
