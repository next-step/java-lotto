package lottery;

import java.util.EnumMap;

public class LotteryResult {

    private final EnumMap<LotteryRank, Integer> winningCounts;
    private final int lotteryPrice;

    public LotteryResult(EnumMap<LotteryRank, Integer> winningCounts, int lotteryPrice) {
        this.winningCounts = winningCounts;
        this.lotteryPrice = lotteryPrice;
    }

    public int winningCounts(LotteryRank lotteryRank) {
        return winningCounts.getOrDefault(lotteryRank, 0);
    }

    public double returnRate() {
        return totalPrizes() / (totalPurchaseAmount() * lotteryPrice);
    }

    private double totalPrizes() {
        return winningCounts.keySet().stream()
                .mapToDouble(lotteryRank -> lotteryRank.prize() * winningCounts(lotteryRank))
                .sum();
    }

    private int totalPurchaseAmount() {
        return winningCounts.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
