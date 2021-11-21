package lotto.view;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoTicketPrintView {

    private LottoTicketPrintView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format("%d개를 구매하였습니다.", lottoTickets.size()));
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            printLottoTicket(lottoTicket.sortLottoTicket());
        }
    }

    private static void printLottoTicket(List<LottoNumber> ticket) {
        System.out.println(ticket.toString());
    }

}
