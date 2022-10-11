package lottery;

import java.util.HashMap;
import java.util.Map;

public class LotteryResult {

    private final Map<Integer, Integer> prizes = new HashMap<>();
    private final Map<Integer, Integer> wonCounts = new HashMap<>();

    private int totalAmounts;
    private int lotteryPrice;

    public int getPrizeOf(int rank) {
        return prizes.get(rank);
    }

    public int getWonCountOf(int rank) {
        return wonCounts.getOrDefault(rank, 0);
    }

    public double getReturnRate() {
        double totalWonPrizes = 0.0;
        for (int rank : prizes.keySet()) {
            totalWonPrizes += getPrizeOf(rank) * getWonCountOf(rank);
        }
        return totalWonPrizes / (totalAmounts * lotteryPrice);
    }

    public void setPrizeOf(int rank, int prize) {
        prizes.put(rank, prize);
    }

    public void setWonCountOf(int rank, int wonCount) {
        wonCounts.put(rank, wonCount);
    }

    public void addWonCountOf(int rank) {
        wonCounts.put(rank, wonCounts.getOrDefault(rank, 0) + 1);
    }

    public void setTotalAmounts(int totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public void setLotteryPrice(int lotteryPrice) {
        this.lotteryPrice = lotteryPrice;
    }
}
