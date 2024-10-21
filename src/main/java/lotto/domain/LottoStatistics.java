package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRank, Integer> prizeCountMap;

    public static LottoStatistics create(List<LottoResult> lottoResults) {
        Map<LottoRank, Integer> prizeCountMap = createEmptyPrizeCountMap();

        for (LottoResult result : lottoResults) {
            LottoRank lottoRank = LottoRank.of(result.getEqualNumberCount(), result.hasBonusNumber());
            prizeCountMap.merge(lottoRank, 1, Integer::sum);
        }

        return new LottoStatistics(prizeCountMap);
    }

    public LottoStatistics(Map<LottoRank, Integer> prizeCountMap) {
        this.prizeCountMap = prizeCountMap;
    }

    public int getCount(LottoRank lottoRank) {
        return prizeCountMap.get(lottoRank);
    }

    public float calculateProfitRate(int totalPurchaseAmount) {
        int totalProfitAmount = calculateTotalProfit();

        float profitRate = (float) totalProfitAmount / totalPurchaseAmount;
        return Math.round(profitRate * 100) / 100.0f;
    }

    public int calculateTotalProfit() {
        int profit = 0;

        for (LottoRank lottoRank : prizeCountMap.keySet()) {
            profit += lottoRank.prizeMoneyAmount * getCount(lottoRank);
        }

        return profit;
    }

    private static Map<LottoRank, Integer> createEmptyPrizeCountMap() {
        Map<LottoRank, Integer> prizeCountMap = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            prizeCountMap.put(lottoRank, 0);
        }

        return prizeCountMap;
    }
}
