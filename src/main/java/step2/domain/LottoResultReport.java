package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultReport {

    static final int EMPTY_COUNT = 0;
    static final int ONE = 1;

    private Map<Rank, Integer> lottoResultReport;

    public LottoResultReport() {
        lottoResultReport = new HashMap<>();
    }

    public int recordRank(Rank rank) {
        if (lottoResultReport.containsKey(rank)) {
            Integer cnt = lottoResultReport.get(rank);
            lottoResultReport.put(rank, cnt + 1);
            return cnt;
        }
        lottoResultReport.put(rank, 1);
        return ONE;
    }

    public int findReportByMatchCount(Rank rank) {
        if (lottoResultReport.containsKey(rank)) {
            return lottoResultReport.get(rank);
        }
        return EMPTY_COUNT;
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
