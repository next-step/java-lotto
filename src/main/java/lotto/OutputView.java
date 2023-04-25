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
                           LottoPrize.findByMatchCount(entry.getKey()).getPrize() +
                           "원)- " +
                           entry.getValue() + "개"
                       )
                   );
    System.out.println("총 수익률은 " + lottoStatistics.getRateOfReturn());
  }
}
