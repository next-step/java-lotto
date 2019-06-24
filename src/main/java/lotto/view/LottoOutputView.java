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

  public static void print(Analyzer analyzer) {
    Map<Prize, Integer> prizeStatus = analyzer.getPrizeStatus();
    Stream.of(Prize.values()).filter(prize -> prize != Prize.LOSE).forEach(prize -> {
      System.out.println(String.format("%d개 일치 (%d원) - %d개", prize.getCountOfMatchingNumbers(), prize.getPrizeMoney(), prizeStatus.getOrDefault(prize, 0)));
    });
  }
}
