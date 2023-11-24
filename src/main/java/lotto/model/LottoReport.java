package lotto.model;

import java.util.List;

public class LottoReport {
    private final List<Integer> result;
    private final double rateOfReturn;

    public LottoReport(List<Integer> result) {
        this.result = result;
        this.rateOfReturn = calculateRateOfReturn();
    }

    private double calculateRateOfReturn() {
        return Math.floor(LottoCashPrize.calculateTotalPrize(this.result) / calculateTotalInvestment() * 100) / 100;
    }

    private double calculateTotalInvestment() {
        int ticketCount = this.result.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return Lotto.price(ticketCount);
    }

    public List<Integer> result() {
        return this.result;
    }

    public double rateOfReturn() {
        return this.rateOfReturn;
    }
}
