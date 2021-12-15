package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADDING_COUNT_VALUE = 1;

    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    public LottoResult(Lottos purchasedLottos, WinningLotto winningLotto) {
        initiate();
        processStatistics(lottoRank(purchasedLottos, winningLotto));
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

    public List<LottoRank> ascendingWinningTypes() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isWinningType)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private void initiate() {
        for (LottoRank lottoRank : LottoRank.values()) {
            results.put(lottoRank, DEFAULT_VALUE);
        }
    }

    private List<LottoRank> lottoRank(Lottos purchasedLottos, WinningLotto winningLotto) {
        return purchasedLottos.lottoRanks(winningLotto);
    }

    private void processStatistics(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            int count = results.get(lottoRank) + ADDING_COUNT_VALUE;
            results.put(lottoRank, count);
        }
    }

    private int calculateTotalEarningsAmount() {
        return ascendingWinningTypes().stream()
                .map(this::calculateEarningAmount)
                .mapToInt(Double::intValue)
                .sum();
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
