import java.util.List;

import domain.LottoGenerator;
import domain.WinningStatistics;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    private LottoGenerator lottoGenerator;

    public void playLottoGames(int money) {
        this.lottoGenerator = new LottoGenerator();
        lottoGenerator.generateLottoResultsFromMoney(money);
    }

    public void getLottoResults() {
        LottoOutputView.printGameCount(lottoGenerator.getCount());
        LottoOutputView.printLottoResults(lottoGenerator.getLottoResults());
    }

    public void getWinningStatistics() {
        List<Integer> lastWeekLottoWinningNumbers = LottoInputView.getLastWeekLottoWinningNumbers();
        WinningStatistics winningStatistics = lottoGenerator.calculateWinningStatistics(lastWeekLottoWinningNumbers);
        LottoOutputView.printBeforeWinnings();
        for (int i = 0; i < winningStatistics.getWinningResults().length; i++) {
            LottoOutputView.printMatchCounts(i, WinningStatistics.OFFSET);
            LottoOutputView.printPrizes(WinningStatistics.WINNING_PRIZES[i]);
            LottoOutputView.printWinningCount(winningStatistics.getWinningResults()[i]);
        }
        LottoOutputView.printReturnOnInvestment(lottoGenerator.getReturnOnInvestment());
    }
}
