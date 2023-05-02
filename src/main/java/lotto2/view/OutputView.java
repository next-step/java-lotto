package lotto2.view;

import java.util.List;
import java.util.Map;
import lotto2.domain.LottoTicket;
import lotto2.domain.Prize;

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

  public static void printLottoResults(Map<Prize, Long> lottoResults) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");
    for(Prize prize : Prize.values()) {
      printLottoResult(prize, lottoResults.getOrDefault(prize, 0L));
    }
  }

  private static void printLottoResult(Prize prize, Long count) {
    if(prize == Prize.NONE) {
      return;
    }
    System.out.printf("%d개 일치 (%d원)- %d개\n", prize.getMatchCount(), prize.getPrizeMoney(), count);
  }

  public static void printProfitRate(Map<Prize, Long> lottoResults, int investMoney) {
    long totalPrizeMoney = calculateTotalPrizeMoney(lottoResults);
    double profitRate = calculateProfitRate(totalPrizeMoney, investMoney);
    System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
  }

  private static double calculateProfitRate(long totalPrizeMoney, int investMoney) {
    return (double) totalPrizeMoney / investMoney;
  }

  private static long calculateTotalPrizeMoney(Map<Prize, Long> lottoResults) {
    long totalPrizeMoney = 0;
    for(Prize prize : Prize.values()) {
      totalPrizeMoney += prize.getPrizeMoney() * lottoResults.getOrDefault(prize, 0L);
    }
    return totalPrizeMoney;
  }
}
