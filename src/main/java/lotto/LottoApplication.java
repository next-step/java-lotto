package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumber;
import lotto.domain.PurchasedAmount;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        PurchasedAmount purchasedAmount = new PurchasedAmount(InputView.showPaymentConsole());
        InputView.showAvailableLottoCount(purchasedAmount);

        LottoTickets lottoTickets = LottoTickets.issue(purchasedAmount);
        InputView.showIssuedLottoTickets(lottoTickets);

        LottoWinningNumber lottoWinningNumber = LottoWinningNumber.create(InputView.showLastWeekWinningNumbersConsole());

        WinningStatistics winningStatistics = new WinningStatistics(lottoWinningNumber, lottoTickets);
        winningStatistics.calculate();

        ResultView.showResult(winningStatistics);
    }
    
}