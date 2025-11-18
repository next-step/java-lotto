package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoTickets tickets = LottoTickets.create(purchaseAmount);

        resultView.printTicketCount(tickets.size());
        resultView.printLottoTickets(tickets);

        Lotto winningNumbers = InputView.inputWinningNumbers();
        WinningResult result = new WinningResult(tickets, winningNumbers);

        resultView.printWinningStatistics(result);
        double profitRate = result.calculateProfitRate(purchaseAmount);
        resultView.printProfitRate(profitRate);
    }
}
