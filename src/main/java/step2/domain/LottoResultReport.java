package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultReport {

    private Map<Rank, Integer> lottoResultReport;
    private int ticketCount;

    public LottoResultReport() {
        lottoResultReport = new HashMap<>();
        ticketCount = 0;
    }

    public int recordRank(Rank rank) {
        ticketCount += 1;
        return lottoResultReport.compute(rank, (key, value) -> getNextValue(value));
    }

    private int getNextValue(Integer value) {
        if(value == null) {
            return 1;
        }
        return value + 1;
    }

    public int findReportByMatchCount(Rank rank) {
        return lottoResultReport.getOrDefault(rank, 0);
    }

    public double calculateProfit() {
        long profit = sum();
        long cost = ticketCount * LottoCommonValue.DEFAULT_LOTTO_PRICE.value();
        return calculateProfitRate(profit, cost);
    }

    long sum() {
        Set<Map.Entry<Rank, Integer>> entries = lottoResultReport.entrySet();
        return entries.stream().mapToLong(e -> e.getKey().prizeMoney() * e.getValue()).sum();
    }

    double calculateProfitRate(long profit, long cost) {
        double rate = (profit - cost) * 1.0 / cost;
        return Math.round(rate * 100) / 100.0;
    }


}
