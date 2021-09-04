package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinningResult;
import lotto.domain.WinningStatistics;

public class ResultView {

  public static void printPurchasedLottos(List<Lotto> lottos) {
    System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      printLotto(lotto);
    }
    System.out.println();
  }

  public static void printWinningResult(WinningResult winningResult) {
    System.out.println("\n당첨 통계\n---------");
    printStatisticsByPrize(winningResult.statistics());
    printRateOfReturn(winningResult.rateOfReturn());
  }

  private static void printLotto(Lotto lotto) {
    String lottoNumbers = lotto.sortedNumbers().stream()
        .map(String::valueOf).reduce((s1, s2) -> s1 + ", " + s2)
        .get();
    System.out.println("[" + lottoNumbers + "]");
  }

  private static void printStatisticsByPrize(WinningStatistics winningStatistics) {
    List<LottoPrize> lottoPrizes = Arrays.stream(LottoPrize.valuesExceptNothing())
        .sorted(Comparator.comparingInt(LottoPrize::matchCnt))
        .collect(Collectors.toList());

    lottoPrizes.forEach(lottoPrize -> {
      int cnt = winningStatistics.cntByLottoPrize(lottoPrize);
      System.out.println(
          lottoPrize.matchCnt() + "개 일치 " + "(" + lottoPrize.prizeMoney() + "원)- " + cnt + "개"
      );
    });
  }

  private static void printRateOfReturn(double rateOfReturn) {
    rateOfReturn = Math.floor(rateOfReturn * 100) / 100.0;

    System.out.print("총 수익률은 " + rateOfReturn + "입니다.");
    if (rateOfReturn < 1) {
      System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
      return;
    }
    if (rateOfReturn > 1) {
      System.out.println("(기준이 1이기 때문에 결과적으로 이득라는 의미임)");
      return;
    }
    System.out.println("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");
  }
}
