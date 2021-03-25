package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Hit;
import lotto.domain.Lottery;
import lotto.domain.Lottos;
import lotto.domain.Result;

public class ResultView {

  public static void showAmountOfLotto(Amount amount) {
    System.out.println(amount.getAmount() + "개를 구매했습니다.");
  }

  public static void showLottoNumbers(Lottos lottos) {
    lottos.getLottos().stream().map(lotto -> lotto.toString())
        .forEach(System.out::println);
    System.out.println();
  }

  public static void showLotteryResult(Lottery lottery, Amount amount) {
    Result result = lottery.getResult();
    System.out.println("\n당첨 통계\n---------");
    System.out.println(showLotteryResult(result));
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

  private static String showLotteryResult(Result result) {
    StringBuilder sb = new StringBuilder();
    for (Hit hit : Hit.all()) {
      sb.append(String.format("%s %d개\n", hit.showHitResult(), result.getResult(hit)));
    }
    return sb.toString();
  }
}
