package lottos.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {

    private int purchaseAmount;
    private List<LottoResult> lottoResults;

    public Statistics(final int purchaseAmount, final List<LottoResult> lottoResults) {
        this.purchaseAmount = purchaseAmount;
        this.lottoResults = lottoResults;
    }

    public Map<Prize, List<Prize>> groupingByPrize() {
        return lottoResults.stream()
                .map(LottoResult::getPrize)
                .collect(Collectors.groupingBy(winningPrize -> winningPrize));
    }

    public double calculateYield() {
        double prizeAmountTotal = calculatePrizeAmountTotal();
        return prizeAmountTotal / this.purchaseAmount;
    }

    private int calculatePrizeAmountTotal() {
        return lottoResults.stream()
                .map(LottoResult::getPrize)
                .map(Prize::getPrizeAmount)
                .reduce(0, Integer::sum);
    }
}
