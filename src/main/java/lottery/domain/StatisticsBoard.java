package lottery.domain;

import java.util.Arrays;
import java.util.Map;

public class StatisticsBoard {

    private final Map<Integer, Integer> winnerTicketsMap;

    public StatisticsBoard(Map<Integer, Integer> winnerTicketsMap) {
        this.winnerTicketsMap = winnerTicketsMap;
    }

    public int findTicketCountsByLotteryRank(LotteryRanks lotteryRank) {
        Integer winnerTicketCounts = winnerTicketsMap.get(lotteryRank.getRequiredNumberCounts());
        if (winnerTicketCounts == null)
            return 0;
        return winnerTicketCounts;
    }

    public double calculateRateOfReturn(PurchasePrice purchasePrice) {
        double revenueTotal = Arrays.stream(LotteryRanks.values())
                .mapToDouble(rank -> rank.getPrizeMoney() * findTicketCountsByLotteryRank(rank))
                .sum();
        return revenueTotal / purchasePrice.getPurchasePrice();
    }
}
