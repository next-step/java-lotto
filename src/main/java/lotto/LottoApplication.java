package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.PurchasedAmount;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        PurchasedAmount purchasedAmount = new PurchasedAmount(InputView.showPaymentConsole());
        ResultView.showAvailableLottoCount(purchasedAmount);

        LottoTickets lottoTickets = LottoTickets.issue(purchasedAmount);
        ResultView.showIssuedLottoTickets(lottoTickets);

        LottoNumbers winningNumbers = LottoNumbers.ofTypeIntegerList(InputView.showLastWeekWinningNumbersConsole());

        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers, lottoTickets);
        winningStatistics.calculate();

        ResultView.showResult(winningStatistics);
    }

}