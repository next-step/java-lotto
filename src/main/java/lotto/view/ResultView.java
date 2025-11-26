package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoResult;

public class ResultView {

  private static final Map<Integer, Integer> RANK_PRIZE = Map.of(
      6, 2_000_000_000,
      5, 1_500_000,
      4, 50_000,
      3, 5_000
  );

  public static void printPurchasedLottos(List<Lotto> lottos) {
    System.out.printf("%d개를 구매했습니다.%n", lottos.size());
    for (Lotto lotto : lottos) {
      System.out.println(lotto.numbers());
    }
    System.out.println();
  }

  public static void printLottoResult(LottoResult result) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    for (int i = 3; i <= 6; i++) {
      int count = result.matchCounts().getOrDefault(i, 0);
      int prize = RANK_PRIZE.get(i);
      System.out.printf("%d개 일치 (%d원)- %d개%n", i, prize, count);
    }

    double profitRate = result.profitRate();
    String status = "손해";
    if (profitRate >= 1) {
      status = "이익";
    }

    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
        profitRate, status);
  }

}
