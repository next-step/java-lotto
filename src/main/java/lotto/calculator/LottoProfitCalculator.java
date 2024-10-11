package lotto.calculator;

import lotto.prize.LottoPrize;

import java.util.Map;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class LottoProfitCalculator {

    private final Map<Integer, Integer> lottoResults;

    public LottoProfitCalculator(Map<Integer, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public double calculateProfitRate(int lottoTicketCount) {
        int totalCost = lottoTicketCount * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    private int calculateTotalPrize() {
        return lottoResults.entrySet().stream()
                .mapToInt(entry -> LottoPrize.getPrizeAmount(entry.getKey()) * entry.getValue())
                .sum();
    }

}
