package step2.view;

import step2.domain.LottoTickets;
import step2.domain.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void announceTotalLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void announceTotalLottoNumbers(LottoTickets lottoTickets) {
        List<Ticket> tickets = lottoTickets.getLottoTickets();

        for (Ticket ticket : tickets) {
            System.out.println(ticket.getLottoNumbers().stream()
                    .collect(Collectors.toList())
            );
        }

    }
}
