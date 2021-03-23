package lotto.view;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;

public class ResultView {

  public static void showAmountOfLotto(int amount) {
    System.out.println(amount + "개를 구매했습니다.");
  }

  public static void showLottoNumbers(List<LottoNumbers> lottos) {
    lottos.stream().map(lotto -> lotto.toString())
        .forEach(System.out::println);
    System.out.println();
  }

  public static void showLotteryResult(Result result, Amount amount) {
    System.out.println("\n당첨 통계\n---------");
    System.out.println(result.showLotteryResult());
    double ratio = result.getRatio(amount);
    System.out.print("총 수익률은 " + ratio + "입니다. ");
    System.out.println(showProfit(result, ratio));
  }

  private static String showProfit(Result result, double ratio) {
    if (result.isProfit(ratio)) {
      return "결과적으로 이득입니다.";
    }
    return "결과적으로 손해입니다.";
  }
}
