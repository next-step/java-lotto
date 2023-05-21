import java.util.List;

import domain.LottoGame;
import domain.LottoResults;
import domain.ManualRequest;
import domain.WinningAnalyzer;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGame lottoGame;
    private WinningAnalyzer winningAnalyzer;

    public void playLottoGames(ManualRequest manualRequest, int money) {
        lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(manualRequest, money);
    }

    public void lottoResults() {
        List<List<Integer>> results = lottoGame.getLottoResults().lottoNumbersToInt();
        int gameCount = lottoGame.getCount();
        LottoOutputView.printLottoResults(gameCount, results);
    }

    public void winningStatistics() {
        LottoResults lottoResults = lottoGame.getLottoResults();
        winningAnalyzer = new WinningAnalyzer(lottoResults, LottoInputView.getWinningNumbers(), LottoInputView.getBonusNumber());
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        LottoOutputView.printBeforeWinnings();
        LottoOutputView.printWinnings(winningStatistics);
    }

    public void returnOnInvestment() {
        int money = lottoGame.getMoney();
        LottoOutputView.printReturnOnInvestment(winningAnalyzer.getReturnOnInvestment(money));
    }
}
