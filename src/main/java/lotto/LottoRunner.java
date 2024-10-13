package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningResults;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        LottoPurchasePrice totalPurchasePrice = InputView.readTotalPurchasePrice();

        List<Lotto> manualLottoTicket = InputView.readManualLotto(totalPurchasePrice);

        LottoTicket lottoTicket = new LottoTicket(totalPurchasePrice, manualLottoTicket);
        ResultView.printLottoDetail(lottoTicket);

        Lotto lastWeekWinningNumbers = InputView.readLastWeekWinningNumbers();

        LottoWinningResults lottoWinningResults = lottoTicket.getWinningResult(lastWeekWinningNumbers);
        ResultView.printWinningStatistics(lottoWinningResults);

        ResultView.printProfitRate(totalPurchasePrice, lottoWinningResults);
    }
}
