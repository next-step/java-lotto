package view;

import domain.LottoTicket;
import domain.Prize;
import java.util.List;
import java.util.Map;

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

  public static void printMatchedCount(Map<Prize, Integer> matchedCountMap) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");
    for (Prize prize : Prize.values()) {
      if (prize != Prize.MATCH_NOT_THING) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", prize.matchCount(), prize.prizeMoney(),
            matchedCountMap.get(prize));
      }
    }
  }



  public static void printProfit(int investMoney, int earnMoney) {
    System.out.printf("총 수익률은 %.2f입니다.", (double) earnMoney / investMoney);
  }
}
