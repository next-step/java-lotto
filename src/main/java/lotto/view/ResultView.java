package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoResult;
import lotto.domain.PRIZES;

public class ResultView {

  public static void showLottos(List<Lotto> tickets) {
    System.out.println(tickets.size() + "개를 구매했습니다.");
    tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
  }

  public static void printResults(LottoChecker lottoChecker) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    for(int i = 3; i < 7; i++){

      int totalWinningCount = getTotalWinningCount(lottoChecker, i);
      System.out.println( i + "개 일치 (" + PRIZES.getWinningMoneyByWinningNumber(i) + "원)- " + totalWinningCount  + "개");
    }

    System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)\n",
        lottoChecker.getProfitRate(), lottoChecker.getProfitRate() >= 1 ? "이득" : "손해");
  }

  private static int getTotalWinningCount(LottoChecker lottoChecker, int winningNumber) {
    return lottoChecker.findTotalWinningCount(winningNumber);
  }
}
