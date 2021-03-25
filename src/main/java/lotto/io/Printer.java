package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public final class Printer {

  private Printer() {}

  public static void printLottoCount(Lottos userLottos) {
    System.out.println(userLottos.count() + "개를 구매했습니다.");
  }

  public static void printLottos(Lottos userLottos) {
    // 번호 나열하는게 있어야겠다.
    System.out.println();
  }

  public static void printWinningStatistics(Lottos userLottos, Lotto winningLotto) {
    System.out.println("당첨 통계");
    System.out.println("----------");
    // 통계 출력하는게 있어야겠다.
  }
}
