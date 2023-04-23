package lotto;

import java.util.Map;

public class OutputView {
  public static void printLottoTickets(LottoTickets lotteryTickets) {
    System.out.println(lotteryTickets.size() + "개를 구매했습니다.");
    for (LottoTicket lotteryTicket : lotteryTickets.getTickets()) {
      System.out.println(lotteryTicket.getNumbers());
    }
  }

  public static void printLottoStatistics(LottoStatistics lottoStatistics) {
    lottoStatistics.getStatistics().entrySet().stream()
                   .sorted(Map.Entry.comparingByKey())
                   .forEach(entry ->
                       System.out.println(
                           entry.getKey() +
                           "개 일치 (" +
                           LottoPrize.getPrize(entry.getKey()) +
                           "원)- " +
                           entry.getValue() + "개"
                       )
                   );
  }
}
