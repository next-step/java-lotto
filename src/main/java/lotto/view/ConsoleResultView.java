package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinMoney;
import lotto.domain.WinStats;

public class ConsoleResultView {

  public static void printIssueLottoNumbers(Lotto lotto) {
    System.out.println("[" + lotto.numbers() + "]");
  }

  public static void printMatchWinCount(WinStats winStats) {

    Arrays.stream(WinMoney.values())
        .forEach(winMoney -> System.out.printf(
            "%d개 일치 (%d원) - %d개\n",
            winMoney.getMatchCount(),
            winMoney.getWinMoney(),
            winStats.getWinCount(winMoney)
        ));
  }

  public static void printYield(String yield) {
    System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield);
  }

  public static void printResultTitle() {
    System.out.println("당첨 통계\n---------");
  }
}
