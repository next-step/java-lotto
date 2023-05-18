package view;

import lotto.AutoLotto;
import lotto.Lottos;
import lotto.ManualLotto;
import lotto.Matches;
import lotto.MatchesStatus;

public class OutputView {

  private OutputView() {
    throw new AssertionError();
  }

  public static void purchasePrice() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void manualPurchaseCount() {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
  }

  public static void manualPurchaseLottoNumbers() {
    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
  }

  public static void lottos(Lottos lottos) {
    System.out.println("\n수동으로 " + lottos.getManualLottos().size() + "장, "
        + "자동으로 " + lottos.getAutoLottos().size()+ "개를 구매했습니다.");
    for (ManualLotto manualLotto : lottos.getManualLottos()) {
      System.out.println(manualLotto.toString());
    }
    for (AutoLotto lotto : lottos.getAutoLottos()) {
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
      stringBuilder.append(matches.getNumberOfMatches()).append("개 일치 ");
      isBonusBall(stringBuilder, matches).append("(")
          .append(matches.getWinningAmount()).append("원)- ")
          .append(matches.getCount(matchesStatus))
          .append("개\n");
    }
    stringBuilder.append("총 수익률은 ").append(matchesStatus.getRate()).append("입니다.");
    System.out.println(stringBuilder);
  }

  private static StringBuilder isBonusBall(StringBuilder stringBuilder, Matches matches) {
    if (matches == Matches.MATCH_FIVE_AND_BONUS) {
      stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).append(", 보너스 볼 일치");
    }
    return stringBuilder;
  }

  public static void bonusBall() {
    System.out.println("보너스 볼을 입력해주세요");
  }
}
