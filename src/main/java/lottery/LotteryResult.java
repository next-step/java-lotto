package lottery;

import java.util.EnumMap;

import static lottery.LotteryRank.valueOf;

public class LotteryResult {

    private final EnumMap<LotteryRank, Integer> winningCounts;

    private final int totalPurchaseAmount;
    private final int lotteryPrice;

    public LotteryResult(EnumMap<LotteryRank, Integer> winningCounts, int totalPurchaseAmount, int lotteryPrice) {
        this.winningCounts = winningCounts;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.lotteryPrice = lotteryPrice;
    }

    public int getWinningCountOfRank(int matchingCount) {
        return winningCounts.getOrDefault(valueOf(matchingCount), 0);
    }

    public double getReturnRate() {
        double totalWonPrizes = 0.0;
        for (LotteryRank lotteryRank : winningCounts.keySet()) {
            int matchingCount = LotteryRank.getMatchingCount(lotteryRank);
            totalWonPrizes += LotteryRank.getPrizeOfMatchingCount(matchingCount) * getWinningCountOfRank(matchingCount);
        }
        return totalWonPrizes / (totalPurchaseAmount * lotteryPrice);
    }

}
