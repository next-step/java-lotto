package lotto.view.result;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class DefaultResultView implements ResultView {

    @Override
    public void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.findAll().stream()
                .forEach(lottoTicket -> printLottoTicket(lottoTicket));
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println("[" + lottoTicket.getLottoTicketNumbers() + "]");
    }
}
