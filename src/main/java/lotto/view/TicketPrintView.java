package lotto.view;

import java.util.Set;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class TicketPrintView {

    private TicketPrintView() {
    }

    public static void ticketPrint(LottoTickets lottoTickets) {
        Set<LottoTicket> tickets = lottoTickets.getTickets();
        for (LottoTicket ticket : tickets) {
            ticketPrint(ticket.getTicket());
        }
    }

    private static void ticketPrint(Set<Integer> ticket) {
        System.out.println(ticket.toString());
    }

}
