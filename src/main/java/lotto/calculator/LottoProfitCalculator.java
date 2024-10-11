package lotto.calculator;

import lotto.prize.Prize;
import lotto.result.LottoResult;

import java.util.Map;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class LottoProfitCalculator {

    private final Map<LottoResult, Integer> lottoResults;

    public LottoProfitCalculator(Map<LottoResult, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public double calculateProfitRate(int lottoTicketCount) {
        int totalCost = lottoTicketCount * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    private int calculateTotalPrize() {
        return lottoResults.entrySet().stream()
                .mapToInt(entry -> Prize.getPrizeAmount(entry.getKey().getMatchedLottoNumbersCount()) * entry.getValue())
                .sum();
    }

}
