package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prize;

import java.util.List;
import java.util.Map;

public class LottoOutputView {
  public static void printCountOf(Lottos lottos) {
    String msg = lottos.getCount() + "개를 구매했습니다.";
    System.out.println(msg);
  }

  public static void print(Lottos lottos) {
    System.out.println(lottos);
  }

  public static void printWinnings() {
//    Map<Integer, List<Integer>> prize = Prize.PRIZE;
//    prize.forEach((winningCount, status) -> {
//      System.out.println(winningCount + "개 일치 (" + status.valueOf(0) + "원) - " + status.valueOf(1) + "개");
//    });
  }
}
