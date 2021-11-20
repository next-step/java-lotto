package lotto.view;

import java.util.List;
import java.util.Set;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class TicketPrintView {

    private TicketPrintView() {
    }

    public static void ticketPrint(LottoTickets lottoTickets) {
        Set<LottoTicket> tickets = lottoTickets.getTickets();
        System.out.println(String.format("%d개를 구매했습니다.", tickets.size()));
        for (LottoTicket ticket : tickets) {
            ticketPrint(ticket.getTicket());
        }
    }

    private static void ticketPrint(List<Integer> ticket) {
        System.out.println(ticket.toString());
    }

}
