package lotto.domain;

import lotto.util.DivisionNumber;

import java.util.Map;

public final class LottoStatistics {
    // LottoRank, Size
    private final Map<LottoRank, Integer> rankings;

    public LottoStatistics(Map<LottoRank, Integer> rankings) {
        this.rankings = rankings;
    }

    public DivisionNumber yield() {
        float totalPrizeAmount = rankings.entrySet().stream()
                .mapToInt(iEntrySet ->
                        iEntrySet.getKey().prizeAmount(iEntrySet.getValue()).intValue()
                ).sum();
        float totalPurchaseAmount = Lotto.PRICE.multiply(totalSize()).intValue();

        return new DivisionNumber(totalPrizeAmount, totalPurchaseAmount);
    }

    private int totalSize() {
        return rankings.values().stream()
                .mapToInt(i -> i)
                .sum();
    }

    public int size(LottoRank lottoRank) {
        if (!rankings.containsKey(lottoRank))
            return 0;
        return rankings.get(lottoRank);
    }
}
