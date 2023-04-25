package lotto;

import lotto.dto.LottoTicketsDto;

import java.util.List;
import java.util.Map;

public class OutputView {
  public static void printLottoTickets(LottoTicketsDto lotteryTicketsDto) {
    System.out.println(lotteryTicketsDto.getLottoTickets().size() + "개를 구매했습니다.");
    for (List<Integer> lotteryTicket : lotteryTicketsDto.getLottoTickets()) {
      System.out.println(lotteryTicket);
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
                           LottoPrize.findByMatchCount(entry.getKey()) +
                           "원)- " +
                           entry.getValue() + "개"
                       )
                   );
  }

  public static void printRateOfReturn(int purchaseAmount, LottoGame lottoGame) {
    float rateOfReturn =
    System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
  }
}
