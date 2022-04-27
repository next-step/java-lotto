package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class ResultView {

  private static final String RESULT_FORMAT = "%d개 일치 (%d원)- %d개\n";
  private static final String YIELD_FORMAT = "총 수익률은 %.2f입니다.";

  private ResultView() {
  }

  public static void printLottos(Lottos lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    printFormattedLottos(lottos);
  }

  public static void printResult(LottoResult result, double yield) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    printRank(result);
    System.out.printf(YIELD_FORMAT, yield);
  }

  private static void printRank(LottoResult result) {
    List<Rank> ranks = Arrays.asList(Rank.values());
    for (Rank rank : ranks) {
      if (rank == Rank.MISS) {
        continue;
      }
      int count = result.getValue().getOrDefault(rank, 0);
      System.out.printf(
          RESULT_FORMAT,
          rank.getMatchCount(),
          rank.getPrizeMoney(),
          count
      );
    }
  }

  private static void printFormattedLottos(Lottos lottos) {
    new StringBuilder();
    for (Lotto lotto : lottos.getValues()) {
      System.out.print("[");
      System.out.print(getFormattedLotto(lotto));
      System.out.println("]");
    }
  }

  private static String getFormattedLotto(Lotto lotto) {
    return lotto.getValues().stream()
        .map(LottoNumber::toString)
        .collect(Collectors.joining(", "));
  }
}
