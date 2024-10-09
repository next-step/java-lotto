package lotto.calculator;

import lotto.prize.LottoPrize;
import lotto.result.LottoResult;

import java.util.Map;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class LottoProfitCalculator {

    private final Map<LottoResult, Integer> lottoResults;
    private final LottoPrize lottoPrize;

    public LottoProfitCalculator(Map<LottoResult, Integer> lottoResults, LottoPrize lottoPrize) {
        this.lottoResults = lottoResults;
        this.lottoPrize = lottoPrize;
    }

    public double calculateProfitRate(int lottoTicketCount) {
        int totalCost = lottoTicketCount * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    private int calculateTotalPrize() {
        return lottoResults.entrySet().stream()
                .mapToInt(entry -> lottoPrize.getLottoPrize(entry.getKey()) * entry.getValue())
                .sum();
    }

}
