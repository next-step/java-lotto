package lotto;

import lotto.domain.LottoOrder;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoOrder lottoOrder = InputView.createLottoOrder();
        LottoTickets tickets = lottoOrder.createTickets();
        ResultView.showPurchaseResult(tickets);

        WinningNumbers winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, tickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
