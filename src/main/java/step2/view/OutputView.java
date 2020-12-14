package step2.view;

import step2.domain.result.LottoResult;

import java.util.List;

public class OutputView {

  private static final String BUYING_AMOUNT_STR = "%s개를 구매했습니다.";
  private static final String WINNING_STATISTICS_STR = "당첨 통계";
  private static final String DASH_STR = "---------";
  private static final String WINNING_MATCH_COUNT_STR = "%d개 일치 (%d원)- %d개";
  private static final String WINNING_EARNING_RATE_STR = "총 수익률은 %,.2f입니다.";

  public static void printLottoCount(int count) {
    System.out.println(String.format(BUYING_AMOUNT_STR, count));
  }

  public static void printLottoList(List<List<Integer>> userLottoList) {
    for (List<Integer> lotto : userLottoList) {
      System.out.println(lotto.toString());
    }
    System.out.println();
  }

  public static void printLottoMatchResult(LottoResult results) {
    System.out.println();
    System.out.println(WINNING_STATISTICS_STR);
    System.out.println(DASH_STR);
    results.getMatchResultMap().keySet().forEach(matchResult -> {
      System.out.println(String.format(WINNING_MATCH_COUNT_STR, matchResult.getMatchCount(), matchResult.getReward(), results.getMatchResultMap().get(matchResult)));
    });
    System.out.println(String.format(WINNING_EARNING_RATE_STR, results.getEarningRate()));
  }
}
