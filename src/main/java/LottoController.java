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
        this.lottoGame = new LottoGame();
        lottoGame.generateLottoResultsFromMoney(money);
    }

    public void getLottoResults() {
        LottoResults lottoResults = lottoGame.getLottoResults();
        LottoOutputView.printGameCount(lottoGame.getCount());
        List<int[]> results = lottoResults.lottoResults();
        LottoOutputView.printLottoResults(results);
    }

    public void getWinningStatistics() {
        LottoResults lottoResults = lottoGame.getLottoResults();
        this.winningAnalyzer = new WinningAnalyzer(lottoResults, LottoInputView.getWinningNumbers(), LottoInputView.getBonusNumber());
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        LottoOutputView.printBeforeWinnings();
        printWinnings(winningStatistics);
        int money = lottoGame.getMoney();
        LottoOutputView.printReturnOnInvestment(winningAnalyzer.getReturnOnInvestment(money));
    }

    private void printWinnings(WinningStatistics winningStatistics) {
        for (WinningPrizes prize : winningStatistics.getWinningResults2().keySet()) {
            printEachPrize(winningStatistics, prize);
        }
    }

    private void printEachPrize(WinningStatistics winningStatistics, WinningPrizes prize) {
        if (WinningPrizes.MISS == prize) {
            return;
        }

        if (WinningPrizes.SECOND_PRIZE == prize) {
            printSecondPrize(winningStatistics, prize);
            return;
        }
        printPrize(winningStatistics, prize);
    }

    private void printPrize(WinningStatistics winningStatistics, WinningPrizes prize) {
        LottoOutputView.printMatchRank(prize.getRank());
        LottoOutputView.printPrizes(prize.getPrizeMoney());
        LottoOutputView.printWinningCount(winningStatistics.getWinningResults2().get(prize));
    }

    private void printSecondPrize(WinningStatistics winningStatistics, WinningPrizes prize) {
        LottoOutputView.printMatchRank(prize.getRank());
        LottoOutputView.printSecondPrizes(prize.getPrizeMoney());
        LottoOutputView.printWinningCount(winningStatistics.getWinningResults2().get(prize));
    }
}
