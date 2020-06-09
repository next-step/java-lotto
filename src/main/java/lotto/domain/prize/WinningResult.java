package lotto.domain.prize;

import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult create(Map<Rank, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    public double calculateWinningRate(double purchaseAmount) {
        double winningPrize = calculateWinningPrize();
        double winningRate = winningPrize / purchaseAmount;
        winningRate = Math.floor(winningRate * 100) / 100.0;
        return winningRate;
    }

    public int tellWinningCount(Rank rank) {
        return winningResult.getOrDefault(rank, 0);
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
