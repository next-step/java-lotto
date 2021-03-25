package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import lotto.constant.Constant;
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

    Arrays.stream(Hit.values()).sorted(Collections.reverseOrder())
        .filter(hit -> hit.hitNumber() != 0)
        .map(hit -> String.format("%s %d개\n", showHitResult(hit), result.getResult(hit)))
        .forEach(sb::append);

    return sb.toString();
  }

  private static String showHitResult(Hit hit) {
    if (hit.prize() == Constant.BONUS_PRIZE) {
      return String.format("%d개 일치, 보너스 볼 일치(%d원)-", hit.hitNumber(), hit.prize());
    }
    return String.format("%d개 일치 (%d원)-", hit.hitNumber(), hit.prize());
  }
}
