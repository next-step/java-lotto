package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    public static final int ADDING_COUNT_VALUE = 1;

    private final Map<LottoResultType, Integer> results = new EnumMap<>(LottoResultType.class);

    LottoResult(List<LottoResultType> purchasedLottoResultTypes) {
        initiate();
        processStatistics(purchasedLottoResultTypes);
    }

    private void initiate() {
        for (LottoResultType lottoResultType : LottoResultType.values()) {
            results.put(lottoResultType, DEFAULT_VALUE);
        }
    }

    private void processStatistics(List<LottoResultType> lottoResultTypes) {
        for (LottoResultType lottoResultType : lottoResultTypes) {
            int count = results.get(lottoResultType) + ADDING_COUNT_VALUE;
            results.put(lottoResultType, count);
        }
    }

    public Map<LottoResultType, Integer> getStatistics() {
        return results;
    }

    public double getEarningsRatio() {
        return calculateEarningsRatio(calculateTotalEarningsAmount());
    }

    private int calculateTotalEarningsAmount() {
        int totalEarningsAmount = 0;
        for (LottoResultType lottoResultType : LottoResultType.winningTypes()) {
            totalEarningsAmount += calculateEarningAmount(lottoResultType);
        }
        return totalEarningsAmount;
    }

    private double calculateEarningAmount(LottoResultType lottoResultType) {
        int reword = lottoResultType.getReward();
        int count = results.get(lottoResultType);
        return Math.multiplyExact(reword, count);
    }

    private double calculateEarningsRatio(int totalEarningsAmount) {
        return Math.floorDiv(totalEarningsAmount, getTotalPurchasedPrice());
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
