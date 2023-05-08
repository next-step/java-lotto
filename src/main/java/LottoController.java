import java.util.List;

import domain.Lotto;
import domain.WinningStatistics;
import view.LottoRequest;
import view.LottoResponse;

public class LottoController {
    private Lotto lotto;

    public void playLottoGames(int money) {
        this.lotto = new Lotto();
        lotto.generateLottoResultsFromMoney(money);
    }

    public void getLottoCount() {
        LottoResponse.printGameCount(lotto.getCount());
    }

    public void getLottoResults() {
            LottoResponse.printLottoResults(lotto.getLottoResults());
    }

    public void getWinningStatistics() {
        List<Integer> lastWeekLottoWinningNumbers = LottoRequest.getLastWeekLottoWinningNumbers();
        WinningStatistics winningStatistics = lotto.calculateWinningStatistics(lastWeekLottoWinningNumbers);
        LottoResponse.printBeforeWinnings();
        for (int i = 0; i < winningStatistics.getWinningResults().length; i++) {
            printMatchCount(i);
            printPrize(i);
            printWinningCount(winningStatistics, i);
        }
    }

    private void printWinningCount(WinningStatistics winningStatistics, int i) {
        LottoResponse.printCount(winningStatistics.getWinningResults()[i]);
        LottoResponse.printSpace();
        LottoResponse.printLine();
    }

    private void printPrize(int i) {
        LottoResponse.printPrize(WinningStatistics.WINNING_PRIZES[i]);
        LottoResponse.printDash(1);
        LottoResponse.printSpace();
    }

    private void printMatchCount(int i) {
        LottoResponse.printMatchCount(i + WinningStatistics.OFFSET);
        LottoResponse.printSpace();
    }

    public void getReturnOnInvestment() {
        LottoResponse.printReturnOnInvestment(lotto.getReturnOnInvestment());
    }
}
