package lottery.domain;

import java.util.Arrays;
import java.util.Map;

public class StatisticsBoard {

    private final Map<LotteryRank, Integer> winnerTicketCountsByRankMap;

    public StatisticsBoard(Map<LotteryRank, Integer> winnerTicketCountsByRankMap) {
        this.winnerTicketCountsByRankMap = winnerTicketCountsByRankMap;
    }

    public int findTicketCountsByLotteryRank(LotteryRank lotteryRank) {
        Integer winnerTicketCounts = winnerTicketCountsByRankMap.get(lotteryRank);
        if (winnerTicketCounts == null)
            return 0;
        return winnerTicketCounts;
    }

    public double calculateRateOfReturn(PurchasePrice purchasePrice) {
        double revenueTotal = Arrays.stream(LotteryRank.values())
                .mapToDouble(rank -> rank.getPrizeMoney() * findTicketCountsByLotteryRank(rank))
                .sum();
        return revenueTotal / purchasePrice.getPurchasePrice();
    }
}
