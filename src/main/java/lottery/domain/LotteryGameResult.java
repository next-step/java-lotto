package lottery.domain;

import java.util.Arrays;
import java.util.Map;

public class LotteryGameResult {

    private static final int ZERO = 0;
    private final Map<LotteryRank, Integer> winnerTicketCountsByRank;

    private LotteryGameResult(Map<LotteryRank, Integer> winnerTicketCountsByRank) {
        this.winnerTicketCountsByRank = winnerTicketCountsByRank;
    }

    public static LotteryGameResult from(Map<LotteryRank, Integer> winnerTicketCountsByRank) {
        return new LotteryGameResult(winnerTicketCountsByRank);
    }

    public int findWinnerTicketCountsByRank(LotteryRank lotteryRank) {
        Integer winnerTicketCounts = winnerTicketCountsByRank.get(lotteryRank);
        return (winnerTicketCounts == null) ? ZERO : winnerTicketCounts;
    }

    public RateOfReturn calculateRateOfReturn(PurchasePrice purchasePrice) {
        double revenueTotal = Arrays.stream(LotteryRank.values())
                .mapToDouble(lotteryRank ->
                        lotteryRank.calculatePrizeMoneySum(findWinnerTicketCountsByRank(lotteryRank)))
                .sum();
        return RateOfReturn.from(revenueTotal / purchasePrice.getPurchasePrice());
    }
}
