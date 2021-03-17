package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {

    public void printLottoTicketInfos(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.getLottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.getLottoNumber().toString()));
    }
}
