import java.util.List;

import domain.LottoGame;
import domain.LottoResults;
import domain.WinningAnalyzer;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGame lottoGenerator;
    private WinningAnalyzer winningAnalyzer;

    public void playLottoGames(int money) {
        this.lottoGenerator = new LottoGame();
        lottoGenerator.generateLottoResultsFromMoney(money);
    }

    public void getLottoResults() {
        LottoResults lottoResults = lottoGenerator.getLottoResults();
        LottoOutputView.printGameCount(lottoGenerator.getCount());
        List<int[]> results = lottoResults.lottoResults();
        LottoOutputView.printLottoResults(results);
    }

    public void getWinningStatistics() {
        LottoResults lottoResults = lottoGenerator.getLottoResults();
        this.winningAnalyzer = new WinningAnalyzer(lottoResults, LottoInputView.getWinningNumbers());
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        LottoOutputView.printBeforeWinnings();
        for (int i = 0; i < winningStatistics.getWinningResults().length; i++) {
            LottoOutputView.printMatchCounts(i, WinningStatistics.OFFSET);
            LottoOutputView.printPrizes(WinningStatistics.WINNING_PRIZES.get(i).getPrizeMoney());
            LottoOutputView.printWinningCount(winningStatistics.getWinningResults()[i]);
        }
        int money = lottoGenerator.getMoney();
        LottoOutputView.printReturnOnInvestment(winningAnalyzer.getReturnOnInvestment(money));
    }
}
