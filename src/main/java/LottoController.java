import java.util.List;

import domain.LottoGame;
import domain.LottoResults;
import domain.WinningAnalyzer;
import domain.WinningPrizes;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGame lottoGame;
    private WinningAnalyzer winningAnalyzer;

    public void playLottoGames(int money) {
        lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(money);
    }

    public void getLottoResults() {
        List<int[]> results = lottoGame.getLottoResults().lottoResults();
        int gameCount = lottoGame.getCount();
        LottoOutputView.printLottoResults(gameCount, results);
    }

    public void getWinningStatistics() {
        LottoResults lottoResults = lottoGame.getLottoResults();
        winningAnalyzer = new WinningAnalyzer(lottoResults, LottoInputView.getWinningNumbers(), LottoInputView.getBonusNumber());
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        LottoOutputView.printBeforeWinnings();
        LottoOutputView.printWinnings(winningStatistics);
    }

    public void getReturnOnInvestment() {
        int money = lottoGame.getMoney();
        LottoOutputView.printReturnOnInvestment(winningAnalyzer.getReturnOnInvestment(money));
    }
}
