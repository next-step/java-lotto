package lotto;

import java.util.ArrayList;
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
        LottoOrder lottoOrder = InputView.getPurchaseAmount();
        List<LottoTicket> manualTickets = InputView.getManualTickets(lottoOrder);
        List<LottoTicket> autoTickets = LottoTicketMachine.purchase(lottoOrder);
        ResultView.showPurchaseResult(manualTickets, autoTickets);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.addAll(manualTickets);
        tickets.addAll(autoTickets);

        WinningNumbers winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, tickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
