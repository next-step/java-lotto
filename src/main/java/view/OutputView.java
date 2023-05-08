package view;

import java.util.List;
import lotto.Lotto;
import lotto.Matches;
import lotto.MatchesStatus;

public class OutputView {

  private OutputView() {
    throw new AssertionError();
  }

  public static void println() {
    System.out.println();
  }

  public static void purchasePrice() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void lottos(List<Lotto> lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      System.out.println(lotto.toString());
    }
  }

  public static void lastWeekWinningNumber() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void statistics(MatchesStatus matchesStatus) {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
    StringBuilder stringBuilder = new StringBuilder();
    for (Matches matches : Matches.values()) {
      stringBuilder.append(matches.getNumberOfMatches())
          .append("개 일치 (").append(matches.getWinningAmount()).append("원)- ")
          .append(matches.getCount(matchesStatus)).append("개\n");
    }
    stringBuilder.append("총 수익률은 ").append(matchesStatus.getRate()).append("입니다.");
    System.out.println(stringBuilder);
  }

}
