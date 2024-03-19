package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {
  public static void lotteryCount(PositiveNumber count) {
    System.out.printf("%s개를 구매했습니다.%n", count);
  }

  public static void lotteryList(Lotteries lotteries) {
    for (Lottery lottery: lotteries) {
      System.out.println(lottery);
    }
    System.out.println();
  }

  public static void stats(Results results) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    for (Map.Entry<Result, PositiveNumber> entry : results.stats().entrySet()) {
      Result result = entry.getKey();
      System.out.printf("%s개 일치 (%s) - %s개", result.matchCount(), Prize.of(result).amount(), entry.getValue());
    }
  }
}
