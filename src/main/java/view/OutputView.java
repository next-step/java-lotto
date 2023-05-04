package view;

import java.util.List;
import lotto.Lotto;
import lotto.MatchesStatus;

public class OutputView {

  public static void println() {
    System.out.println();
  }

  public static void purchasePrice() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void lottos(List<Lotto> lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto :
        lottos) {
      System.out.println(lotto.toString());
    }
  }

  public static void lastWeekWinningNumber() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void statistics(MatchesStatus matchesStatus) {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
    System.out.println("3개 일치 (5000원)- " + matchesStatus.getThreeMatches() + "개");
    System.out.println("4개 일치 (50000원)- " + matchesStatus.getFourMatches() + "개");
    System.out.println("5개 일치 (1500000원)- " + matchesStatus.getFiveMatches() + "개");
    System.out.println("6개 일치 (2000000000원)- " + matchesStatus.getSixMatches() + "개");
    System.out.println("총 수익률은 " + matchesStatus.getRate() + "입니다.");
  }

}
