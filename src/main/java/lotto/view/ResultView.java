package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.PRIZES;
import lotto.domain.WinningResult;

public class ResultView {

  public static void showLottos(Lottos tickets) {
    System.out.println("수동으로" + tickets.getManualCount() + "장, 자동으로" +  tickets.getAutoCount() + "개를 구매했습니다.");
    tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
  }

  public static void printResults(WinningResult result) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    printIfCount(result, PRIZES.FIFTH, "3개 일치 (5000원)- %d개");
    printIfCount(result, PRIZES.FOURTH, "4개 일치 (50000원)- %d개");
    printIfCount(result, PRIZES.THIRD, "5개 일치 (1500000원)- %d개");
    printIfCount(result, PRIZES.SECOND, "5개 일치, 보너스 볼 일치(30000000원) - %d개");
    printIfCount(result, PRIZES.FIRST, "6개 일치 (2000000000원)- %d개");

    System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)\n",
        result.getProfitRate(), result.getProfitRate() >= 1 ? "이득" : "손해");
  }

  private static void printIfCount(WinningResult result, PRIZES prize, String format) {
    int count = result.getWinningCount(prize);
    System.out.println(String.format(format, count));
  }
}
