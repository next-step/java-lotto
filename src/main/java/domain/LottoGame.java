package domain;

import java.util.List;

public class LottoGame {
    private LottoResults lottoResults;

    private Money money;

    private WinningStatistics winningStatistics;

    public LottoGame(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public LottoGame() {
        this.lottoResults = new LottoResults();
    }

    public void generateLottoResultsFromMoney(int money) {
        this.money = new Money(money);
        for (int i = 0; i < getCount(); i++) {
            lottoResults.add(LottoNumGenerator.generateNumbers());
        }
    }

    public int getCount() {
        return money.getCount();
    }

    public WinningStatistics calculateWinningStatistics(List<Integer> lastWeekLottoWinningNumbers) {
        this.winningStatistics = new WinningStatistics(lastWeekLottoWinningNumbers);
        lottoResults.calculateWinningStatistics(winningStatistics);
        return winningStatistics;
    }

    public List<int[]> getLottoResults() {
        return lottoResults.getLottoResults();
    }

    public float getReturnOnInvestment() {
        float totalWinning = winningStatistics.getTotalWinnings();
        return totalWinning / money.getMoney();
    }
}

