package lotto.view;

import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class ResultView {

  private static final String RESULT_FORMAT = "%d개 일치 (%d원)- %d개\n";
  private static final String YIELD_FORMAT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private ResultView() {
  }

  public static void printLottos(Lottos lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    System.out.println(lottos);
  }

  public static void printResult(LottoResult result, double yield) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.println(getFormattedResult(result));
    System.out.printf(YIELD_FORMAT, yield);
  }

  private static String getFormattedResult(LottoResult result) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Rank, Integer> entry : result.getValue().entrySet()) {
      if (entry.getKey() == Rank.MISS) {
        continue;
      }
      stringBuilder.append(
          String.format(
              RESULT_FORMAT,
              entry.getKey().getMatchCount(),
              entry.getKey().getPrizeMoney(),
              entry.getValue()
          )
      );
    }
    return stringBuilder.toString();
  }
}
