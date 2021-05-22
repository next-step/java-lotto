package lotto.domain;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private final String RESULT_MATCH_COUNT_FORMAT = "%d개 일치 (%d원)- %d개%n";
    private final String RESULT_PROFIT_RATIO_FORMAT = "총 수익률은 %.2f입니다. (원금보전 시, 수익률이 1입니다)";
    private final int DEFAULT_COUNT = 0;

    private final TreeMap<MatchStatus, Integer> lottoResult;
    private int purchaseAmount;
    private float profitRatio;

    public LottoResult(int purchaseAmount) {
        this.lottoResult = new TreeMap<>();
        this.purchaseAmount = purchaseAmount;
        setDefaultValues();
    }

    private void setDefaultValues() {
        for (MatchStatus status : MatchStatus.values()) {
            lottoResult.put(status, DEFAULT_COUNT);
        }
        lottoResult.remove(MatchStatus.ELSE);
    }

    public void updateValue(MatchStatus status) {
        int resultCount = DEFAULT_COUNT;
        if (status.equals(MatchStatus.ELSE)) {
            return;
        }
        if (lottoResult.containsKey(status)) {
            resultCount = lottoResult.get(status);
        }
        lottoResult.put(status, resultCount + 1);
    }

    public int getResultCount(MatchStatus status) {
        return lottoResult.get(status);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<MatchStatus, Integer> entry : lottoResult.entrySet()) {
            MatchStatus matchStatus = entry.getKey();
            int matchCount = entry.getValue();
            stringBuilder.append(String.format(RESULT_MATCH_COUNT_FORMAT,
                    matchStatus.getMatchCount(),
                    matchStatus.getPrice(),
                    matchCount));
        }
        this.profitRatio = calculateProfitRatio();
        stringBuilder.append(String.format(RESULT_PROFIT_RATIO_FORMAT, profitRatio));
        return stringBuilder.toString();
    }

    public float calculateProfitRatio() {
        long totalPrize = calculateTotalPrize();
        return totalPrize / (float) purchaseAmount;

    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<MatchStatus, Integer> entry : lottoResult.entrySet()) {
            MatchStatus matchStatus = entry.getKey();
            int matchCount = entry.getValue();
            totalPrize += (long) matchStatus.getPrice() * matchCount;
        }
        return totalPrize;
    }
}
