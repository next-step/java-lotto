package lotto2.view;

import java.util.List;
import lotto2.domain.LottoTicket;

public class OutputView {

  public static void printLottoTickets(List<LottoTicket> tickets) {
    System.out.println(tickets.size() + "개를 구매했습니다.");
    for (LottoTicket ticket : tickets) {
      printLottoTicket(ticket);
    }
  }

  private static void printLottoTicket(LottoTicket ticket) {
    System.out.println(String.join(", ", ticket.getNumbers().toString()));
  }

}
