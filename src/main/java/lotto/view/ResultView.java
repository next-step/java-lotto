package lotto.view;

import lotto.LottoMatchResult;
import lotto.LottoRank;
import lotto.Lottos;
import lotto.ProfitRate;

public class ResultView {

  public static void printPurchasedLottos(Lottos lottos) {
    System.out.printf("%d개를 구매했습니다.%n", lottos.count());
    for (String line : lottos.toDisplayStrings()) {
      System.out.println(line);
    }
    System.out.println();
  }

  public static void printLottoResult(LottoMatchResult matchResult, ProfitRate profitRate) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    for (LottoRank rank : LottoRank.values()) {
      int matchCount = rank.matchCount();
      int count = matchResult.countMatches(matchCount);
      int prize = rank.prize();
      System.out.printf("%d개 일치 (%d원)- %d개%n", matchCount, prize, count);
    }

    double rate = profitRate.value();
    String status = "손해";
    if (rate >= 1) {
      status = "이익";
    }

    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
        rate, status);
  }
}
