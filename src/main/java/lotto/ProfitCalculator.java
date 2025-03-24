package lotto;

import java.util.List;
import java.util.Map;

public class ProfitCalculator {
    public static float calculate(Map<PrizeRank, Integer> summary) {
        int count = 0;
        int sum = 0;
        for (PrizeRank prize : summary.keySet()) {
            count += summary.get(prize);
            sum += prize.getPrize() * summary.get(prize);
        }
        return (float) sum / (count * LottoTicket.PRICE);
    }
}
