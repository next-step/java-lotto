import java.util.List;

import domain.LottoGame;
import domain.ManualRequest;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGame lottoGame;

    public void playLottoGames(ManualRequest manualRequest, int money) {
        lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(manualRequest, money);
    }

    public void lottoResults() {
        List<List<Integer>> results = lottoGame.getLottoResultsToInt();
        int gameCount = lottoGame.getCount();
        LottoOutputView.printLottoResults(gameCount, results);
    }

    public void winningStatistics() {
        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics(LottoInputView.getWinningNumbers(), LottoInputView.getBonusNumber());
        LottoOutputView.printBeforeWinnings();
        LottoOutputView.printWinnings(winningStatistics);
    }

    public void returnOnInvestment() {
        LottoOutputView.printReturnOnInvestment(lottoGame.getReturnOnInvestment());
    }
}
