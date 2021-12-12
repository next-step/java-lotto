package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADDING_COUNT_VALUE = 1;

    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    public LottoResult(Lottos purchasedLottos, Lotto winningLotto) {
        initiate();
        processStatistics(lottoRank(purchasedLottos.getLottos(), winningLotto));
    }

    public Map<LottoRank, Integer> getStatistics() {
        return results;
    }

    public double earningsRatio() {
        return calculateEarningsRatio(calculateTotalEarningsAmount());
    }

    public int countByType(LottoRank lottoRank) {
        return results.get(lottoRank);
    }

    private void initiate() {
        for (LottoRank lottoRank : LottoRank.values()) {
            results.put(lottoRank, DEFAULT_VALUE);
        }
    }

    private List<LottoRank> lottoRank(List<Lotto> purchasedLottos, Lotto winningLotto) {
        return purchasedLottos.stream()
                .map(lotto -> lotto.findLottoRank(winningLotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private void processStatistics(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            int count = results.get(lottoRank) + ADDING_COUNT_VALUE;
            results.put(lottoRank, count);
        }
    }

    private int calculateTotalEarningsAmount() {
        int totalEarningsAmount = 0;
        for (LottoRank lottoRank : LottoRank.WINNING_TYPES) {
            totalEarningsAmount += calculateEarningAmount(lottoRank);
        }
        return totalEarningsAmount;
    }

    private double calculateEarningAmount(LottoRank lottoRank) {
        return Math.multiplyExact(lottoRank.reward(), countByType(lottoRank));
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
