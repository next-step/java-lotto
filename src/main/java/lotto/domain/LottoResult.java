package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    public static final int ADDING_COUNT_VALUE = 1;

    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    LottoResult(List<LottoRank> purchasedLottoRanks) {
        initiate();
        processStatistics(purchasedLottoRanks);
    }

    private void initiate() {
        for (LottoRank lottoRank : LottoRank.values()) {
            results.put(lottoRank, DEFAULT_VALUE);
        }
    }

    private void processStatistics(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            int count = results.get(lottoRank) + ADDING_COUNT_VALUE;
            results.put(lottoRank, count);
        }
    }

    public Map<LottoRank, Integer> getStatistics() {
        return results;
    }

    public double getEarningsRatio() {
        return calculateEarningsRatio(calculateTotalEarningsAmount());
    }

    private int calculateTotalEarningsAmount() {
        int totalEarningsAmount = 0;
        for (LottoRank lottoRank : LottoRank.winningTypes()) {
            totalEarningsAmount += calculateEarningAmount(lottoRank);
        }
        return totalEarningsAmount;
    }

    private double calculateEarningAmount(LottoRank lottoRank) {
        int reword = lottoRank.getReward();
        int count = results.get(lottoRank);
        return Math.multiplyExact(reword, count);
    }

    private double calculateEarningsRatio(int totalEarningsAmount) {
        return (double) totalEarningsAmount / getTotalPurchasedPrice();
    }

    private int getTotalPurchasedSize() {
        return results.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int getTotalPurchasedPrice() {
        return Math.multiplyExact(getTotalPurchasedSize(), Lotto.PRICE);
    }
}
