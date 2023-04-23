package lotto;

import java.util.Map;

public class OutputView {
  public static void printLottoTickets(LottoTickets lotteryTickets) {
    System.out.println(lotteryTickets.size() + "개를 구매했습니다.");
    for (LottoTicket lotteryTicket : lotteryTickets.getTickets()) {
      System.out.println(lotteryTicket.getNumbers());
    }
    System.out.println();
  }

  public static void printLottoStatistics(LottoStatistics lottoStatistics) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("--------------");
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

  public static void printRateOfReturn(int purchaseAmount, LottoGame lottoGame) {
    float rateOfReturn = LottoPrize.getRateOfReturn(purchaseAmount, lottoGame.getLottoTickets().getLottoStatistics());
    System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
  }
}
