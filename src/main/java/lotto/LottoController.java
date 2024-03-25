package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        Amount amount = new Amount(InputView.askPurchaseAmount());
        LottoTickets lottoTickets = new LottoTickets(amount);
        ResultView.printLottoTickets(lottoTickets);

        String[] winningNumbers = InputView.askWinningNumbers();
        String bonusBall = InputView.askBonusBall();
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusBall);

        ResultView.printWinningStatistics(lottoTickets.winnerCounts(winningTicket));
        ResultView.printEarningsRate(lottoTickets.earningsRate(winningTicket));
    }
}
