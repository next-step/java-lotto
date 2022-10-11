package lottery;

import java.util.HashMap;
import java.util.Map;

public class LotteryResult {

    private final Map<Integer, Integer> prizes = new HashMap<>();
    private final Map<Integer, Integer> wonAmounts = new HashMap<>();

    private int totalAmounts;
    private int lotteryPrice;

    public int getPrizeOf(int rank) {
        return prizes.get(rank);
    }

    public int getWonAmountOf(int rank) {
        return wonAmounts.getOrDefault(rank, 0);
    }

    public double getReturnRate() {
        double totalWonPrizes = 0.0;
        for (int rank : prizes.keySet()) {
            totalWonPrizes += getPrizeOf(rank) * getWonAmountOf(rank);
        }
        return totalWonPrizes / (totalAmounts * lotteryPrice);
    }

    public void setPrizeOf(int rank, int prize) {
        prizes.put(rank, prize);
    }

    public void setWonAmountOf(int rank, int wonAmount) {
        wonAmounts.put(rank, wonAmount);
    }

    public void addWonAmountOf(int rank) {
        wonAmounts.put(rank, wonAmounts.getOrDefault(rank, 0) + 1);
    }

    public void setTotalAmounts(int totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public void setLotteryPrice(int lotteryPrice) {
        this.lotteryPrice = lotteryPrice;
    }
}
