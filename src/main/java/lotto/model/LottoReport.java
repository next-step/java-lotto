package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoReport {
    private final List<LottoRank> result;
    private final double rateOfReturn;

    public LottoReport(List<LottoRank> result) {
        this.result = result;
        this.rateOfReturn = calculateRateOfReturn();
    }

    private double calculateRateOfReturn() {
        return Math.floor(calculateTotalPrize() / calculateTotalInvestment() * 100) / 100;
    }

    private int calculateTotalPrize() {
        return this.result.stream()
                .mapToInt(result -> result.cashPrize())
                .sum();
    }

    private double calculateTotalInvestment() {
        return LottoSeller.price(this.result.size());
    }

    public int countRank(LottoRank rank) {
        return Collections.frequency(this.result, rank);
    }

    public double rateOfReturn() {
        return this.rateOfReturn;
    }
}
