package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

  private static final String WINNING_RATE_INTRO = "당첨 통계";
  private static final String WINNING_STATISTIC_CLASSIFICATION = "---------";

  public static void outputCountPurchasedLotto(int purchasedLotto) {
    System.out.println(purchasedLotto + "개를 구매했습니다.");
  }

  public static void outputPurchasedLottoInfo(Lottos lottos) {
    System.out.println(lottos);
  }

  public static void outputWinningRate(Map<LottoRank, Integer> matchResult) {
    System.out.println(WINNING_RATE_INTRO);
    System.out.println(WINNING_STATISTIC_CLASSIFICATION);

    matchResult.entrySet().stream()
        .filter(entry -> entry.getKey() != LottoRank.NON_MATCH)
        .forEach(entry -> {
          System.out.println(
              entry.getKey().getNumberOfMatch() + "개 일치 (" + entry.getKey().getReward() + "원) - "
                  + entry.getValue() + "개");
        });
  }

  public static void outputProfitRatio(double calculateProfitRatio) {
    System.out.print("총 수익률은 " + calculateProfitRatio + "입니다.");
    if (calculateProfitRatio < 1) {
      System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
  }
}
