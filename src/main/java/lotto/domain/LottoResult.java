package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int DEFAULT_VALUE = 0;
    private static final int DECIMAL_CALCULATION_NUMBER = 100;

    private final Map<LottoRank, Integer> lottoResults;

    public LottoResult(HashMap<LottoRank, Integer> results) {
        lottoResults = results;
    }

    public int getResult(LottoRank key) {
        return lottoResults.getOrDefault(key, DEFAULT_VALUE);
    }

    public double rewardRatio() {
        Set<LottoRank> lottoRanks = lottoResults.keySet();
        long totalReward = getTotalReward(lottoRanks);
        long purchaseAmount = getPurchaseAmount(lottoRanks);
        return rateCalculation(totalReward, purchaseAmount);
    }

    public static double rateCalculation(long totalReward, double purchaseAmount) {
        return Math.floor((totalReward / purchaseAmount) * DECIMAL_CALCULATION_NUMBER) / DECIMAL_CALCULATION_NUMBER;
    }

    private long getPurchaseAmount(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                    .mapToLong(lottoResults::get)
                    .sum() * ONE_LOTTO_PRICE;
    }

    private long getTotalReward(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                    .mapToLong(lottoRank -> lottoRank.getTotalReward(lottoResults.get(lottoRank)))
                    .sum();
    }
}
