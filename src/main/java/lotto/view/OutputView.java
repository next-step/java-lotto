package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.dto.LottoTicketsDto;

import java.util.Map;

public class OutputView {
  public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
    System.out.println(lottoTicketsDto.lottoTickets.size() + "개를 구매했습니다.");
    lottoTicketsDto.lottoTickets
        .forEach(System.out::println);
    System.out.println();
  }

  public static void printStatistics(LottoStatistics lottoStatistics) {
    System.out.println("\n당첨 통계");
    System.out.println("----------------");
    lottoStatistics.getStatistics().entrySet().stream()
                   .sorted(Map.Entry.comparingByKey())
                   .filter(entry -> entry.getKey().getMatchNumbersCount() >= 3)
                   .forEach(entry -> System.out.println(entry.getKey().getMatchNumbersCount() + "개 일치 (" + entry.getKey().getPrize().getAmount() + ")- " + entry.getValue() + "개"));
    System.out.println("총 수익률은 " + lottoStatistics.getRateOfReturn() + "입니다.");
  }
}
