package lotto;

import java.util.List;
import lotto.domain.LottoOrder;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoOrder lottoOrder = InputView.createLottoOrder();

        List<LottoTicket> tickets = LottoTicketMachine.purchase(lottoOrder);
        ResultView.showPurchaseResult(lottoOrder, tickets);

        WinningNumbers winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, tickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
