package lotto.domain.winning;

import lotto.domain.PurchaseAmount;

import java.util.Map;

public class LottoWinningResult {
    private Map<LottoWinningAmount, Long> winningResultMap;

    private LottoWinningResult(Map<LottoWinningAmount, Long> winningResultMap) {
        this.winningResultMap = winningResultMap;
    }

    public static LottoWinningResult of(Map<LottoWinningAmount, Long> winningResultMap) {
        return new LottoWinningResult(winningResultMap);
    }

    public long getWinningCount(LottoWinningAmount lottoWinningAmount) {
        return winningResultMap.getOrDefault(lottoWinningAmount, 0L);
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
