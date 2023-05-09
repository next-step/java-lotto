package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultReport {

    static final int ZERO = 0;

    private Map<PrizeMoney, Integer> lottoResultReport;

    public LottoResultReport() {
        lottoResultReport = new HashMap<>();
    }

    public int recordRank(PrizeMoney prizeMoney) {
        if (lottoResultReport.containsKey(prizeMoney)) {
            Integer cnt = lottoResultReport.get(prizeMoney);
            lottoResultReport.put(prizeMoney, cnt + 1);
            return cnt;
        }
        lottoResultReport.put(prizeMoney, 1);
        return 1;
    }

    public int findReportByMatchCount(PrizeMoney prizeMoney) {
        if (lottoResultReport.containsKey(prizeMoney)) {
            return lottoResultReport.get(prizeMoney);
        }
        return ZERO;
    }

    public double calculateProfit(int gameCount) {
        long profit = sum();
        long cost = gameCount * LottoCommonValue.DEFAULT_LOTTO_PRICE.value();
        return calculateProfitRate(profit, cost);
    }

    long sum() {
        Set<Map.Entry<PrizeMoney, Integer>> entries = lottoResultReport.entrySet();
        return entries.stream().mapToLong(e -> e.getKey().prizeMoney() * e.getValue()).sum();
    }

    double calculateProfitRate(long profit, long cost) {
        double rate = (profit - cost) * 1.0 / cost;
        return Math.round(rate * 100) / 100.0;
    }


}
