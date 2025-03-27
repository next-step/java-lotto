package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {
    public void printLottoTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : tickets.getAll()) {
            System.out.println(ticket);
        }
    }
}
