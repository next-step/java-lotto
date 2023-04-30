package view;

import domain.LottoTicket;
import java.util.List;

public class ResultView {

  public static void printLottoTickets(List<LottoTicket> lottoTickets) {
    System.out.printf("%d개를 구매했습니다.", lottoTickets.size());
    System.out.println();
    for (LottoTicket lottoTicket : lottoTickets) {
      printLottoTicket(lottoTicket);
    }
  }

  private static void printLottoTicket(LottoTicket lottoTicket) {
    List<Integer> numbers = lottoTicket.numbers();
    System.out.println(String.join(", ", numbers.toString()));
  }

}
