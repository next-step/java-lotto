package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADDING_COUNT_VALUE = 1;

    private final Map<LottoResultType, Integer> results = new EnumMap<>(LottoResultType.class);

    public LottoResult(Lottos purchasedLottos, Lotto winningLotto) {
        initiate();
        processStatistics(lottoResultTypes(purchasedLottos.getLottos(), winningLotto));
    }

    public Map<LottoResultType, Integer> getStatistics() {
        return results;
    }

    public double earningsRatio() {
        return calculateEarningsRatio(calculateTotalEarningsAmount());
    }

    public int countByType(LottoResultType lottoResultType) {
        return results.get(lottoResultType);
    }

    private void initiate() {
        for (LottoResultType lottoResultType : LottoResultType.values()) {
            results.put(lottoResultType, DEFAULT_VALUE);
        }
    }

    private List<LottoResultType> lottoResultTypes(List<Lotto> purchasedLottos, Lotto winningLotto) {
        return purchasedLottos.stream()
                .map(lotto -> lotto.findLottoResultType(winningLotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private void processStatistics(List<LottoResultType> lottoResultTypes) {
        for (LottoResultType lottoResultType : lottoResultTypes) {
            int count = results.get(lottoResultType) + ADDING_COUNT_VALUE;
            results.put(lottoResultType, count);
        }
    }

    private int calculateTotalEarningsAmount() {
        int totalEarningsAmount = 0;
        for (LottoResultType lottoResultType : LottoResultType.WINNING_TYPES) {
            totalEarningsAmount += calculateEarningAmount(lottoResultType);
        }
        return totalEarningsAmount;
    }

    private double calculateEarningAmount(LottoResultType lottoResultType) {
        return Math.multiplyExact(lottoResultType.reward(), countByType(lottoResultType));
    }

    private double calculateEarningsRatio(int totalEarningsAmount) {
        return (double) totalEarningsAmount / totalPurchasedPrice();
    }

    private int totalPurchasedPrice() {
        return Math.multiplyExact(totalPurchasedSize(), Lotto.PRICE);
    }

    private int totalPurchasedSize() {
        return results.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
