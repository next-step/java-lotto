package view;

import domain.LottoTicket;
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

  public static void printMatchedCount(Map<Integer, Integer> matchedCountMap) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");
    printCount(matchedCountMap, 3);
    printCount(matchedCountMap, 4);
    printCount(matchedCountMap, 5);
    printCount(matchedCountMap, 6);
  }

  private static void printCount(Map<Integer, Integer> matchedCountMap, int key) {
    System.out.printf("%d개 일치 (%d원)- %d개", key, LottoTicket.calculatePrize(key),
        matchedCountMap.getOrDefault(key, 0));
    System.out.println();
  }

  public static void printProfit(int investMoney, int earnMoney) {
    System.out.printf("총 수익률은 %.2f입니다.", (double) earnMoney / investMoney);
  }
}
