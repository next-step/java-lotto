package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningResults {

    private final List<LottoWinningResult> winningResults;

    public LottoWinningResults() {
        this.winningResults = new ArrayList<>();
        initLottoWinningResults();
    }

    public List<LottoWinningResult> getWinningResults() {
        return winningResults;
    }

    public long getTotalWinningAmount() {
        return winningResults.stream()
                .mapToInt(result -> result.getLottoWinningStatus().getAmount() * result.getCount())
                .sum();
    }

    public double getProfitRate(final int totalPurchasePrice) {
        double totalWinningAmount = getTotalWinningAmount();
        return Math.floor(totalWinningAmount / totalPurchasePrice * 100) / 100;
    }

    private void initLottoWinningResults() {
        LottoWinningStatus[] values = LottoWinningStatus.values();
        for (int i = 0; i < values.length; i++) {
            winningResults.add(new LottoWinningResult(values[i]));
        }
    }

    public void incrementWinningResults(final int count) {
        switch (count) {
            case 3:
                winningResults.get(0).increment();
                break;
            case 4:
                winningResults.get(1).increment();
                break;
            case 5:
                winningResults.get(2).increment();
                break;
            case 6:
                winningResults.get(3).increment();
                break;
            default:
                break;
        }
    }
}
