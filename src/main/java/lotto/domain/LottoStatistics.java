package lotto.domain;

import lotto.util.number.DivisionNumber;
import lotto.util.number.MultiplicationNumber;

import java.util.Map;

public final class LottoStatistics {
    // LottoRank, Size
    private final Map<LottoRank, Long> rankings;

    public LottoStatistics(Map<LottoRank, Long> rankings) {
        this.rankings = rankings;
    }

    public DivisionNumber yield() {
        Number totalPrizeAmount = rankings.entrySet().stream()
                .mapToLong(iEntrySet ->
                    iEntrySet.getKey().prizeAmount(
                            iEntrySet.getValue()
                    ).longValue()
                ).sum();
        Number totalPurchaseAmount = new MultiplicationNumber(Lotto.PRICE, totalSize());

        return new DivisionNumber(totalPrizeAmount, totalPurchaseAmount);
    }

    public int totalSize() {
        return rankings.values().stream()
                .mapToInt(Long::intValue)
                .sum();
    }

    public int size(LottoRank lottoRank) {
        if (!rankings.containsKey(lottoRank))
            return 0;
        return rankings.get(lottoRank).intValue();
    }
}
