package lotto.view;

import lotto.type.LottoBundle;
import lotto.type.LottoPrize;

import java.util.Arrays;
import java.util.List;

public class OutputView {

  public static void showLottoCount(int lottoCount) {
    System.out.printf("%d개를 구매했습니다.%n", lottoCount);
  }

  public static void showLottoBundle(LottoBundle lottoBundle) {
    System.out.println(lottoBundle);
  }

  public static void showLottoPrize(List<LottoPrize> lottoPrizeList) {
    System.out.printf("%n당첨 통계%n---------%n");
    Arrays.stream(LottoPrize.values()).filter(LottoPrize::hasPrize).forEach(lottoPrizeType -> System.out.printf(
        "%s - %d개%n",
        lottoPrizeType ,
        lottoPrizeList.stream().filter(lottoPrize -> lottoPrize.equals(lottoPrizeType)).count()
    ));
  }

  public static void showReturnRate(double returnRate) {
    System.out.printf("총 수익률은 %.2f입니다.%n", returnRate);
  }
}
