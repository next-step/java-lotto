package lotto.domain;

import java.util.*;

public class LottoWinningResults {

    private final Map<LottoWinningStatus, LottoWinningResult> winningResultMap;

    public LottoWinningResults() {
        this.winningResultMap = new TreeMap<>();
        initLottoWinningResults();
    }

    public Map<LottoWinningStatus, LottoWinningResult> getWinningResultMap() {
        return Collections.unmodifiableMap(winningResultMap);
    }

    public long getTotalWinningAmount() {
        return winningResultMap.values().stream()
                .mapToInt(result -> result.getWinningAmount())
                .sum();
    }

    public double getProfitRate(final LottoPurchasePrice purchasePrice) {
        double totalWinningAmount = getTotalWinningAmount();
        return Math.floor(totalWinningAmount / purchasePrice.getValue() * 100) / 100;
    }

    private void initLottoWinningResults() {
        LottoWinningStatus[] values = LottoWinningStatus.values();
        for (int i = 0; i < values.length; i++) {
            winningResultMap.put(values[i], new LottoWinningResult(values[i]));
        }
    }

    public void incrementWinningResults(final LottoMatchNumberInfo matchNumberInfo) {
        if (matchNumberInfo.isSecond()) {
            winningResultMap.get(LottoWinningStatus.FIVE_AND_BONUS).increment();
            return;
        }
        winningResultMap.values().stream()
                .filter(winningResult -> winningResult.isWinningCountEqual(matchNumberInfo.getCount()))
                .findFirst()
                .ifPresent(LottoWinningResult::increment);
    }

}
