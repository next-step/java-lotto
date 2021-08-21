package step2.view;

import step2.domain.LottoTickets;
import step2.domain.Ticket;

import java.util.List;

public class ResultView {

    public static void announceTotalLottoTicket(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void announceTotalLottoNumbers(LottoTickets lottoTickets) {
        List<Ticket> tickets = lottoTickets.getLottoTickets();

        tickets.forEach(ticket ->
            System.out.println(ticket.toString())
        );
    }
}
