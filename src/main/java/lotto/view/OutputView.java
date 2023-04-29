package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.MatchNumbersCount;
import lotto.domain.dto.LottoTicketsDto;

import java.util.Map;

public class OutputView {
  public static void printLottoTickets(LottoTicketsDto lottoTicketsDto, int manualLottoTicketsCount) {
    System.out.println(
        "\n수동으로 " +
        manualLottoTicketsCount +
        "장, 자동으로 " +
        (lottoTicketsDto.lottoTickets.size() - manualLottoTicketsCount) +
        "장을 구매했습니다."
    );
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
                   .forEach(entry -> System.out.println(
                       entry.getKey().getMatchNumbersCount() +
                       "개 일치" +
                       (entry.getKey() == MatchNumbersCount.MATCH_5_AND_BONUS ? ", 보너스볼 일치" : "") +
                       " (" + entry.getKey().getPrize().getAmount() + "원) - " +
                       entry.getValue() + "개")
                   );
    System.out.println("총 수익률은 " + lottoStatistics.getRateOfReturn() + "입니다.");
  }
}
