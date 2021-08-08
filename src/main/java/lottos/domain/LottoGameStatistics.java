package lottos.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameStatistics {

    private final int purchaseAmount;
    private final List<LottoResult> lottoResults;

    public LottoGameStatistics(final int purchaseAmount, final List<LottoResult> lottoResults) {
        this.purchaseAmount = purchaseAmount;
        this.lottoResults = lottoResults;
    }

    public Map<LottoPrize, List<LottoPrize>> groupingByPrize() {
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
                .map(LottoPrize::getPrizeAmount)
                .reduce(0, Integer::sum);
    }
}
