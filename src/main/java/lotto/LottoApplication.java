package lotto;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(purchasePrice);
        ResultView.showPurchaseResult(lottoTickets);

        LottoTicket winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
