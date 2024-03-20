package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        Amount amount = new Amount(InputView.askPurchaseAmount());
        LottoTickets lottoTickets = new LottoTickets(amount);
        ResultView.printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.askWinningNumbers());
        ResultView.printWinningStatistics(lottoTickets, winningNumbers);
        ResultView.printEarningsRate(lottoTickets, winningNumbers);
    }
}
