package lotto.view;

import java.util.Map;
import lotto.domain.LottoTickets;

public class ResultView {

  public void printLottos(LottoTickets lottoTickets) {
    System.out.println(lottoTickets.size() + "개를 구매했습니다.");
    System.out.println(lottoTickets);
  }

  public void printWinningStatistics(Map<Integer, Integer> statistics, double profitRate) {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
    System.out.println("3개 일치 (5000원)- " + statistics.get(3) + "개");
    System.out.println("4개 일치 (50000원)- " + statistics.get(4) + "개");
    System.out.println("5개 일치 (1500000원)- " + statistics.get(5) + "개");
    System.out.println("6개 일치 (2000000000원)- " + statistics.get(6) + "개");
    if (profitRate == 1.0) {
      System.out.println("총 수익률은 1.00입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");
      return;
    }
    if (profitRate < 1.0) {
      System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profitRate);
      return;
    }
    if (profitRate > 1.0) {
      System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)", profitRate);
    }
  }
}
