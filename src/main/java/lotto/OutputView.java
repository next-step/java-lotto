package lotto;

import java.util.List;

public class OutputView {

    public void displayLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size()+"개를 구매했습니다.");
        for (LottoTicket ticket:tickets) {
            System.out.println(ticket.toString());
        }

    }
}
