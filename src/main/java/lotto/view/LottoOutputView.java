package lotto.view;

import lotto.model.*;

import java.util.Map;
import java.util.stream.Stream;

public class LottoOutputView {
  public static void printCountOf(Lottos lottos) {
    String msg = lottos.getCount() + "개를 구매했습니다.";
    System.out.println(msg);
  }

  public static void printPickedNumbersOf(Lottos lottos) {
    System.out.println(lottos);
  }

  public static void print(Report report) {
    printResultOf(report.getPrizeStatus());
    print(report.rateOfReturn());
  }

  private static void printResultOf(Map<Prize, Integer> prizeStatus) {
    Stream.of(Prize.values())
            .filter(prize -> prize != Prize.LOSE)
            .forEach(prize -> System.out.println(
                    String.format("%d개 일치 (%d원) - %d개", prize.getCountOfMatchingNumbers(), prize.getPrizeMoney(), prizeStatus.getOrDefault(prize, 0))));
  }

  private static void print(double rateOfReturn) {
    System.out.println(String.format("총 수익률은 %.2f 입니다.", rateOfReturn));
  }
}
