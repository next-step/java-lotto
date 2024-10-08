package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinningResults;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        int totalPurchasePrice = InputView.readTotalPurchasePrice();

        List<List<Integer>> lottoResults = Lotto.issueTickets(totalPurchasePrice);
        ResultView.printLottoDetail(lottoResults);

        List<Integer> lastWeekWinningNumbers = InputView.readLastWeekWinningNumbers();
        LottoWinningResults lottoWinningResults = LottoStatistics.winningStatistics(lottoResults, lastWeekWinningNumbers);

        ResultView.printWinningStatistics(lottoWinningResults);
        ResultView.printProfitRate(totalPurchasePrice, lottoWinningResults);
    }
}
