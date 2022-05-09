package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

  private static final String WINNING_RATE_INTRO = "당첨 통계";
  private static final String WINNING_STATISTIC_CLASSIFICATION = "---------";
  private static final String WINNING_RATE_INFO_MESSAGE = "%d개 일치 (%d원) - %d개";
  private static final String TOTAL_PROFIT_RATIO_MESSAGE = "총 수익률은 %.2f입니다.";
  private static final String PROFIT = "이득";
  private static final String LOSS = "손해";
  private static final String SAME = "동일";
  private static final String PROFIT_RATIO_MESSAGE = "(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

  private static final int BASIC_PROFIT_RATIO = 1;

  private OutputView() {
    throw new AssertionError();
  }

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
          System.out.println(makeWinningLottoRateMessage(entry.getKey().getNumberOfMatch(),
              entry.getKey().getReward(), entry.getValue()));
        });
  }

  private static String makeWinningLottoRateMessage(int numberOfMatch, int reward, int totalMatch) {
    return String.format(WINNING_RATE_INFO_MESSAGE, numberOfMatch, reward, totalMatch);
  }

  public static void outputProfitRatio(double calculateProfitRatio) {
    String message = String.format(TOTAL_PROFIT_RATIO_MESSAGE, calculateProfitRatio);

    if (calculateProfitRatio > BASIC_PROFIT_RATIO) {
      message += String.format(PROFIT_RATIO_MESSAGE, PROFIT);
    }

    if (calculateProfitRatio == BASIC_PROFIT_RATIO) {
      message += String.format(PROFIT_RATIO_MESSAGE, SAME);
    }

    if (calculateProfitRatio < BASIC_PROFIT_RATIO) {
      message += String.format(PROFIT_RATIO_MESSAGE, LOSS);
    }

    System.out.println(message);
  }
}
