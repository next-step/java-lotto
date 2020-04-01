package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.view.LottoMachineResultView;
import lotto.view.LottoMachineView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoTickets lottoTickets = LottoMachineView.lottoPurchaseView();
        LottoMachineResultView.showTicketNumber(lottoTickets);

        LottoTicket winningTicket = LottoMachineView.latestWinningLotto();
        LottoResult lottoResult = LottoMachineView.checkWinningResult(winningTicket, lottoTickets);

        LottoMachineResultView.printLottoResult(lottoResult);


    }
}
