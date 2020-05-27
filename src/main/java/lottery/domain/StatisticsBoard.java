package lottery.domain;

import java.util.Arrays;
import java.util.Map;

public class StatisticsBoard {

    private static final int ZERO = 0;
    private final Map<LotteryRank, Integer> winnerTicketCountsByRankMap;

    public StatisticsBoard(Map<LotteryRank, Integer> winnerTicketCountsByRankMap) {
        this.winnerTicketCountsByRankMap = winnerTicketCountsByRankMap;
    }

    public int findTicketCountsByLotteryRank(LotteryRank lotteryRank) {
        Integer winnerTicketCounts = winnerTicketCountsByRankMap.get(lotteryRank);
        if (winnerTicketCounts == null)
            return ZERO;
        return winnerTicketCounts;
    }

    public double calculateRateOfReturn(PurchasePrice purchasePrice) {
        double revenueTotal = Arrays.stream(LotteryRank.values())
                .mapToDouble(lotteryRank -> lotteryRank.getPrizeMoney() * findTicketCountsByLotteryRank(lotteryRank))
                .sum();
        return revenueTotal / purchasePrice.getPurchasePrice();
    }
}
