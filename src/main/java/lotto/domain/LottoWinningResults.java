package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningResults {

    private final List<LottoWinningResult> winningResults;

    public LottoWinningResults() {
        this.winningResults = new ArrayList<>();
        initLottoWinningResults();
    }

    public List<LottoWinningResult> getWinningResults() {
        return Collections.unmodifiableList(winningResults);
    }

    public long getTotalWinningAmount() {
        return winningResults.stream()
                .mapToInt(result -> result.getLottoWinningStatus().getAmount() * result.getCount())
                .sum();
    }

    public double getProfitRate(final LottoPurchasePrice purchasePrice) {
        double totalWinningAmount = getTotalWinningAmount();
        return Math.floor(totalWinningAmount/ purchasePrice.getValue() * 100) / 100;
    }

    private void initLottoWinningResults() {
        LottoWinningStatus[] values = LottoWinningStatus.values();
        for (int i = 0; i < values.length; i++) {
            winningResults.add(new LottoWinningResult(values[i]));
        }
    }

    public void incrementWinningResults(final int count) {
        winningResults.stream()
                .filter(winningResult -> winningResult.getLottoWinningStatus().getWinningCount() == count)
                .findFirst()
                .ifPresent(LottoWinningResult::increment);
    }
}
