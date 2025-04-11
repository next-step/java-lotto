package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoTickets;
import lotto.domain.PrizeRank;

public class ResultView {

  public void printLottoCount(int manualCount, int autoCount) {
    System.out.printf("%n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, autoCount);
  }

  public void printLottos(LottoTickets lottoTickets) {
    lottoTickets.getLottoTickets().stream()
        .map(lotto -> formatLottoNumbers(lotto.getNumbers()))
        .forEach(System.out::println);
  }

  private String formatLottoNumbers(List<Integer> numbers) {
    return numbers.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  public void printWinningStatistics(Map<PrizeRank, Integer> statistics, double profitRate) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    for (PrizeRank rank : PrizeRank.values()) {
      System.out.printf("%d개 일치%s (%d원) - %d개%n",
          rank.getMatchCount(),
          rank.hasBonusBall() ? ", 보너스 볼 일치" : "",
          rank.getPrizeMoney(),
          statistics.getOrDefault(rank, 0));
    }
    printProfitRateMessage(profitRate);
  }

  private void printProfitRateMessage(double profitRate) {
    if (profitRate == 1.0) {
      System.out.println("총 수익률은 1.00입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");
      return;
    }
    if (profitRate < 1.0) {
      System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitRate);
      return;
    }
    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)%n", profitRate);
  }
}
