package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoRunner {
    public static void main(String[] args) {
        LottoPurchasePrice totalPurchasePrice = InputView.readTotalPurchasePrice();

        LottoTicket manualLottoTicket = InputView.readManualLotto(totalPurchasePrice);

        LottoTicket lottoTicket = LottoTicketGenerator.createTicket(totalPurchasePrice, manualLottoTicket);
        ResultView.printLottoDetail(lottoTicket);

        Lotto lastWeekWinningNumbers = InputView.readLastWeekWinningNumbers();

        LottoWinningResults lottoWinningResults = lottoTicket.getWinningResult(lastWeekWinningNumbers);
        ResultView.printWinningStatistics(lottoWinningResults);

        ResultView.printProfitRate(totalPurchasePrice, lottoWinningResults);
    }
}
