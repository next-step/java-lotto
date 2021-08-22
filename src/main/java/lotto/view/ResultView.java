package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinningStatics;

public class ResultView {

  public static void printPurchasedLottos(List<Lotto> lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      printLotto(lotto);
    }
    System.out.println();
  }

  private static void printLotto(Lotto lotto) {
    String lottoNumbers = lotto.getLottoNumbers().stream().sorted()
        .map(String::valueOf).reduce((s1, s2) -> s1 + ", " + s2).get();
    System.out.println("[" + lottoNumbers + "]");
  }

  public static void printWinningStatics(WinningStatics winningStatics) {
    System.out.println("\n당첨 통계\n---------");
    printStaticsByPrize(winningStatics);
    printRateOfReturn(winningStatics.getRateOfReturn());
  }

  private static void printStaticsByPrize(WinningStatics winningStatics) {
    List<LottoPrize> lottoPrizes = Arrays.stream(LottoPrize.values())
        .filter(lottoPrize -> lottoPrize != LottoPrize.NOTHING)
        .sorted((o1, o2) -> Integer.compare(o2.getMatchedCnt(), o1.getMatchedCnt()))
        .collect(Collectors.toList());

    lottoPrizes.forEach(lottoPrize -> {
      String result = lottoPrize.getMatchedCnt() + "개 일치 "
          + "(" + lottoPrize.getPrizeMoney() + "원)-"
          + winningStatics.getResultByMatchedCnt(lottoPrize.getMatchedCnt()) + "개";
      System.out.println(result);
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
