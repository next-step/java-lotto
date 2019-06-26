package lotto.domain;

import java.util.Map;

public class LottoWinningResult {
    private Map<LottoWinningAmount, Long> winningResultMap;

    private LottoWinningResult(Map<LottoWinningAmount, Long> winningResultMap) {
        this.winningResultMap = winningResultMap;
    }

    public static LottoWinningResult of(Map<LottoWinningAmount, Long> winningResultMap) {
        return new LottoWinningResult(winningResultMap);
    }

    public long getTotalWinningAmount() {
        return winningResultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    public double getEarningRate(PurchaseAmount purchaseAmount) {
        return (double) getTotalWinningAmount() / purchaseAmount.getUsedPurchaseAmount();
    }
}
