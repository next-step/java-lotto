package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningResults;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoRunner {
    public static void main(String[] args) {
        int totalPurchasePrice = InputView.readTotalPurchasePrice();

        LottoTicket lottoTicket = new LottoTicket(totalPurchasePrice);
        ResultView.printLottoDetail(lottoTicket);

        Lotto lastWeekWinningNumbers = InputView.readLastWeekWinningNumbers();
        LottoWinningResults lottoWinningResults = lottoTicket.getWinningResult(lastWeekWinningNumbers);

        ResultView.printWinningStatistics(lottoWinningResults);
        ResultView.printProfitRate(totalPurchasePrice, lottoWinningResults);
    }
}
