package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoReport {
    private final Map<LottoRank, Long> result;
    private final double rateOfReturn;

    public LottoReport(Map<LottoRank, Long> result) {
        this.result = result;
        this.rateOfReturn = calculateRateOfReturn();
    }

    private double calculateRateOfReturn() {
        return Math.floor(calculateTotalPrize() / calculateTotalInvestment() * 100) / 100;
    }

    private long calculateTotalPrize() {
        return this.result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().cashPrize() * entry.getValue())
                .sum();
    }

    private double calculateTotalInvestment() {
        return LottoSeller.price(this.result.values().stream()
                .mapToInt(count -> count.intValue())
                .sum());
    }

    public long countRank(LottoRank rank) {
        return this.result.getOrDefault(rank, 0L);
    }

    public double rateOfReturn() {
        return this.rateOfReturn;
    }
}
