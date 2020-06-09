package lotto.domain.prize;

import java.util.Map;

public class WinningResult {
    private final Map<Integer, Integer> winningResult;

    private WinningResult(Map<Integer, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult create(Map<Integer, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    public double calculateWinningRate(double purchaseAmount) {
        double winningPrize = calculateWinningPrize();
        double winningRate = winningPrize / purchaseAmount;
        winningRate = Math.floor(winningRate * 100) / 100.0;
        return winningRate;
    }

    public int tellWinningCount(int key) {
        return winningResult.getOrDefault(key, 0);
    }

    private int calculateWinningPrize() {
        int winPrize = 0;
        for (Rank rank : Rank.values()) {
            int winningCount = winningResult.getOrDefault(rank.getCountOfMatch(), 0);
            winPrize += rank.calculateTotalPrice(winningCount);
        }
        return winPrize;
    }
}
