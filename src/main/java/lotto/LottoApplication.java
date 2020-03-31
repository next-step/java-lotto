package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningTicket;
import lotto.view.LottoMachineView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoTickets lottoTickets = LottoMachineView.lottoPurchaseView();
        LottoMachineView.showTicketNumber(lottoTickets);

        LottoWinningTicket lottoWinningTicket = LottoMachineView.latestWinningLotto();
        LottoResult lottoResult = LottoMachineView.checkWinningResult(lottoWinningTicket, lottoTickets);

        LottoMachineView.printLottoResult(lottoResult);


    }
}
