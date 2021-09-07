package step2.utils;

import step2.domain.statistics.Amount;
import step2.domain.statistics.Profit;
import step2.domain.statistics.Revenue;
import step2.domain.statistics.Rank;

public class ProfitTestUtil {

    public static Profit createProfit(Rank rank, int rankQuantity, int totalQuantity) {
        final Revenue revenue = new Revenue(rank.winnings * rankQuantity);
        final Amount amount = new Amount(totalQuantity);
        return new Profit(revenue, amount);
    }
}
