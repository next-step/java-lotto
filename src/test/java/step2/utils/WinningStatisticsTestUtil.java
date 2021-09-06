package step2.utils;

import step2.domain.statistics.Amount;
import step2.domain.statistics.Profit;
import step2.domain.statistics.WinningStatistics;
import step2.vo.Rank;

public class WinningStatisticsTestUtil {

    public static WinningStatistics createWinningStatistics(Rank rank, int rankQuantity, int totalQuantity) {
        final Profit profit = new Profit(rank.winnings * rankQuantity);
        final Amount amount = new Amount(totalQuantity);
        return new WinningStatistics(profit, amount);
    }
}
