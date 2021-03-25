package lotto.io;

import static lotto.domain.Rank.FIVE;
import static lotto.domain.Rank.FOUR;
import static lotto.domain.Rank.NONE;
import static lotto.domain.Rank.SIX;
import static lotto.domain.Rank.THREE;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public final class Printer {

  private Printer() {}

  public static void printLottoCount(Lottos userLottos) {
    System.out.println(userLottos.count() + "개를 구매했습니다.");
  }

  public static void printLottos(Lottos userLottos) {
    userLottos.print();
    System.out.println();
  }

  public static void printWinningStatistics(Lottos userLottos, Lotto winningLotto, Money userMoney) {
    System.out.println("당첨 통계");
    System.out.println("----------");
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);

    printMessageAndCountOfRank(winningStatistics, THREE);
    printMessageAndCountOfRank(winningStatistics, FOUR);
    printMessageAndCountOfRank(winningStatistics, FIVE);
    printMessageAndCountOfRank(winningStatistics, SIX);

    long winnings = winningStatistics.totalMoney().toInteger();
    double yield = (double) winnings / userMoney.toInteger();

    System.out.println("당첨금: " + winnings + "원");
    System.out.printf("총 수익률은 %.2f입니다.", yield);
    if (yield < 1) {
      System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
    System.out.println();
  }

  private static void printMessageAndCountOfRank(WinningStatistics winningStatistics, Rank rank) {
    if (!NONE.equals(rank)) {
      System.out.println(rank.getMessage() + " - " + winningStatistics.countOf(rank) + "개");
    }
  }
}
