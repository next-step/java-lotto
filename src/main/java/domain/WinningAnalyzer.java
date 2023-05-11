package domain;

import java.util.List;

public class WinningAnalyzer {
    private LottoResults lottoResults;
    private WinningStatistics winningStatistics;

    public WinningAnalyzer(LottoResults lottoResults, List<Integer> winningNumbers) {
        this.lottoResults = lottoResults;
        this.winningStatistics = new WinningStatistics(winningNumbers);
    }

    public WinningStatistics calculateWinningStatistics() {
        lottoResults.calculateWinningStatistics(winningStatistics);
        return winningStatistics;
    }

    public float getReturnOnInvestment(int money) {
        float totalWinning = winningStatistics.getTotalWinnings();
        return totalWinning / money;
    }
}
