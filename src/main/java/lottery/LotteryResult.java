package lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryResult {

    private final List<Integer> ranksInUse;
    private final Map<Integer, Integer> wonCounts = new HashMap<>();

    private final int totalAmounts;
    private final int lotteryPrice;

    public LotteryResult(List<Integer> ranksInUse, int totalAmounts, int lotteryPrice) {
        this.ranksInUse = ranksInUse;
        this.totalAmounts = totalAmounts;
        this.lotteryPrice = lotteryPrice;
    }

    public int getPrizeOf(int rank) {
        return LotteryRanks.getPrizeOfRank(rank);
    }

    public int getWonCountOf(int rank) {
        validateRankInUse(rank);
        return wonCounts.getOrDefault(rank, 0);
    }

    public double getReturnRate() {
        double totalWonPrizes = 0.0;
        for (int rank : ranksInUse) {
            totalWonPrizes += getPrizeOf(rank) * getWonCountOf(rank);
        }
        return totalWonPrizes / (totalAmounts * lotteryPrice);
    }

    public void addWonCountOf(int rank) {
        wonCounts.put(rank, wonCounts.getOrDefault(rank, 0) + 1);
    }

    protected void setWonCountOf(int rank, int wonCount) {
        wonCounts.put(rank, wonCount);
    }

    private void validateRankInUse(int rank) {
        if (!ranksInUse.contains(rank)) {
            throw new IllegalArgumentException("지원하지 않는 등수입니다.");
        }
    }

}
