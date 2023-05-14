package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultReport {

    private Map<Rank, Integer> lottoResultReport;

    public LottoResultReport() {
        lottoResultReport = new HashMap<>();
    }

    public int recordRank(Rank rank) {
        Integer value = lottoResultReport.getOrDefault(rank, 0);
        lottoResultReport.put(rank, value + 1);
        return lottoResultReport.get(rank);
    }

    public int findReportByMatchCount(Rank rank) {
        return lottoResultReport.getOrDefault(rank, 0);
    }

    public double calculateProfit(int gameCount) {
        long profit = sum();
        long cost = gameCount * LottoCommonValue.DEFAULT_LOTTO_PRICE.value();
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
