package lotto;

import lotto.domain.LottoOrder;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoOrder lottoOrder = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(lottoOrder);
        ResultView.showPurchaseResult(lottoTickets);

        LottoTicket winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
