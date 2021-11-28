package lotto.view;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public class LottoTicketPrintView {

    private LottoTicketPrintView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets, Money money) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", money.getManualCount(), money.getAutoCount()));
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            printLottoTicket(lottoTicket.sortLottoTicket());
        }
    }

    private static void printLottoTicket(List<LottoNumber> ticket) {
        System.out.println(ticket.toString());
    }

}
