import domain.LottoGame;
import domain.LottoResults;
import domain.ManualRequest;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoService {
    private LottoGame lottoGame;

    public void playLottoGames(ManualRequest manualRequest, int money) {
        lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(manualRequest, money);
    }

    public void lottoResults() {
        LottoResults lottoResults = lottoGame.getLottoResults();
        int gameCount = lottoGame.getCount();
        LottoOutputView.printLottoResults(gameCount, lottoResults);
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
