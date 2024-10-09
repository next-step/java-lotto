package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinningResults;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        int totalPurchasePrice = InputView.readTotalPurchasePrice();

        List<List<Integer>> ticket = LottoTicket.issue(totalPurchasePrice);
        ResultView.printLottoDetail(ticket);

        List<Integer> lastWeekWinningNumbers = InputView.readLastWeekWinningNumbers();
        LottoWinningResults lottoWinningResults = LottoStatistics.winningStatistics(ticket, lastWeekWinningNumbers);

        ResultView.printWinningStatistics(lottoWinningResults);
        ResultView.printProfitRate(totalPurchasePrice, lottoWinningResults);
    }
}
