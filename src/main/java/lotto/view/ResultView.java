package lotto.view;

import lotto.LottoMatchResult;
import lotto.LottoRank;
import lotto.Lottos;
import lotto.ProfitRate;

public class ResultView {

  public static void printPurchasedLottos(Lottos lottos, int manualCount) {
    System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, lottos.count() - manualCount);
    for (String line : lottos.toDisplayStrings()) {
      System.out.println(line);
    }
    System.out.println();
  }

  public static void printLottoResult(LottoMatchResult matchResult, ProfitRate profitRate) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    for (LottoRank rank : LottoRank.values()) {
      printRank(matchResult, rank);
    }

    double rate = profitRate.value();
    String status = "손해";
    if (rate >= 1) {
      status = "이익";
    }

    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
        rate, status);
  }

  private static void printRank(LottoMatchResult matchResult, LottoRank rank) {
    if (rank == LottoRank.MISS) {
      return;
    }
    int count = matchResult.countMatches(rank);
    int prize = rank.prize();
    if (rank == LottoRank.SECOND) {
      System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", prize, count);
      return;
    }
    System.out.printf("%d개 일치 (%d원)- %d개%n", rank.matchCount(), prize, count);
  }
}
