package lotto.model;

import java.util.Map;

public class WinningResults {
    private final Map<WinningResult, Integer> winningResults;

    public WinningResults(Map<WinningResult, Integer> winningResults) {
        this.winningResults = winningResults;
    }

    public double calculateEarningRate(int purchasingPrice) {
        double sum = 0;
        for (WinningResult winningResult : winningResults.keySet()) {
            sum += winningResult.multiplyWinningAmount(winningResults.get(winningResult));
        }
        return sum / purchasingPrice;
    }

    public Map<WinningResult, Integer> getWinningResults() {
        return winningResults;
    }
}
