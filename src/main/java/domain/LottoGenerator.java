package domain;

import java.util.List;

public class LottoGenerator {
    private LottoResults lottoResults;

    private Money money;

    private WinningStatistics winningStatistics;

    public LottoGenerator(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public LottoGenerator() {
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

    public WinningStatistics calculateWinningStatistics(List<Integer> winningNumbers) {
        this.winningStatistics = new WinningStatistics(winningNumbers);
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

