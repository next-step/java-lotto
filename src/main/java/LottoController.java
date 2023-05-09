import java.util.List;

import domain.LottoGame;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGame lottoGame;

    public void playLottoGames(int money) {
        this.lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(money);
    }

    public void getLottoResults() {
        LottoOutputView.printGameCount(lottoGame.getCount());
        LottoOutputView.printLottoResults(lottoGame.getLottoResults());
    }

    public void getWinningStatistics() {
        List<Integer> lastWeekLottoWinningNumbers = LottoInputView.getLastWeekLottoWinningNumbers();
        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics(lastWeekLottoWinningNumbers);
        LottoOutputView.printBeforeWinnings();
        for (int i = 0; i < winningStatistics.getWinningResults().length; i++) {
            LottoOutputView.printMatchCounts(i, WinningStatistics.OFFSET);
            LottoOutputView.printPrizes(WinningStatistics.WINNING_PRIZES[i]);
            LottoOutputView.printWinningCount(winningStatistics.getWinningResults()[i]);
        }
        LottoOutputView.printReturnOnInvestment(lottoGame.getReturnOnInvestment());
    }
}
