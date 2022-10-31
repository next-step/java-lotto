package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultStat {
    private final Map<LottoResult, Integer> resultMap;

    public LottoResultStat(List<LottoResult> results) {
        this.resultMap = results.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public int getWinnerCount(LottoResult result) {
        return resultMap.getOrDefault(result, 0);
    }

    public double getProfitMargin(LottoPrice price, LottoPrizeInfo prizeInfo) {
        double result = 0.0;
        for (LottoResult winnerClass : LottoResult.values()) {
            result += prizeInfo.getPrize(winnerClass) * getWinnerCount(winnerClass);
        }
        return result / price.getPurchasePrice(totalTicketCount());
    }

    private int totalTicketCount() {
        int count = 0;
        for (LottoResult key : resultMap.keySet()) {
            count += resultMap.get(key);
        }
        return count;
    }
}
