package lotto.view;

import lotto.model.*;

import java.util.Map;
import java.util.stream.Stream;

public class LottoOutputView {

  private static final String FORMAT_FOR_BUYING_LOTTOS = "%d 개를 구매했습니다.";
  private static final String FORMAT_FOR_RATE_OF_RETURN = "총 수익률은 %.2f 입니다.";
  private static final String REWARD_FORMAT_FOR_SECOND_PRIZE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
  private static final String REWARD_FORMAT_FOR_COMMON_PRIZE = "%d개 일치 (%d원) - %d개";

  public static void printCountOf(Lottos lottos) {
    System.out.printf(FORMAT_FOR_BUYING_LOTTOS, lottos.getCount());
    printLineBreak();
  }

  public static void printPickedNumbersOf(Lottos lottos) {
    lottos.getLottos().forEach(System.out::println);
  }

  public static void print(Report report) {
    printResultOf(report.getPrizeStatus());
    print(report.getRateOfReturn());
  }

  private static void printResultOf(Map<Prize, Integer> prizeStatus) {
    Stream.of(Prize.values())
            .filter(prize -> prize != Prize.LOSE)
            .forEach(prize -> {
              printRewardWith(prize, prizeStatus);
              printLineBreak();
            });
  }

  private static void printRewardWith(Prize prize, Map<Prize, Integer> prizeStatus) {
    if (prize.equals(Prize.SECOND)) {
      System.out.printf(REWARD_FORMAT_FOR_SECOND_PRIZE, prize.getCountOfMatchingNumbers(), prize.getPrizeMoney(), prizeStatus.getOrDefault(prize, 0));
      return;
    }
    System.out.printf(REWARD_FORMAT_FOR_COMMON_PRIZE, prize.getCountOfMatchingNumbers(), prize.getPrizeMoney(), prizeStatus.getOrDefault(prize, 0));
  }

  private static void printLineBreak() {
    System.out.println();
  }

  private static void print(double rateOfReturn) {
    printLineBreak();
    System.out.printf(FORMAT_FOR_RATE_OF_RETURN, rateOfReturn);
  }
}
