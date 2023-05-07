package lotto3.view;

import lotto3.domain.LottoResults;
import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;
import lotto3.domain.Prize;

public class OutputView {

  public static LottoTickets printLottoTickets(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
    System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoTickets.size(),
        autoLottoTickets.size());

    LottoTickets totalLottoTickets = addAllLottoTickets(manualLottoTickets, autoLottoTickets);

    for (LottoTicket ticket : totalLottoTickets.tickets()) {
      printLottoTicket(ticket);
    }

    return totalLottoTickets;
  }

  private static LottoTickets addAllLottoTickets(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
    manualLottoTickets.addAll(autoLottoTickets);
    return manualLottoTickets;
  }

  private static void printLottoTicket(LottoTicket ticket) {
    System.out.println(String.join(", ", ticket.getNumbers().toString()));
  }

  public static void printLottoResults(LottoResults results) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");
    for(Prize prize : Prize.values()) {
      printLottoResult(prize, results.getMatchedCount(prize));
    }
  }

  private static void printLottoResult(Prize prize, Long matchedCount) {
    if(prize == Prize.NONE) {
      return;
    }

    if (prize == Prize.SECOND) {
      System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", prize.getMatchCount(), prize.getPrizeMoney(), matchedCount);
      return;
    }

    System.out.printf("%d개 일치 (%d원)- %d개\n", prize.getMatchCount(), prize.getPrizeMoney(), matchedCount);
  }

  public static void printProfitRate(double profitRate) {
    System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
  }

}
