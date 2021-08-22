package step2.view;

import step2.model.Lotto;
import step2.model.LottoWin;
import step2.model.Lottos;
import step2.model.WinnerMoney;

public class ResultView {

  private static final String LEFT_BRACKET = "[";
  private static final String RIGHT_BRACKET = "]";
  private static final String COMMA = ",";
  private static final String BLANK_SPACE = " ";

  public void printPurchasedLotto(Lottos lottos) {

    System.out.println(lottos.getLottosSize() + "개를 구매했습니다.");

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      printLotto(lottos.getLotto(i));
    }

    System.out.println();
  }

  private void printLotto(Lotto lotto) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(LEFT_BRACKET);
    for (Integer integer : lotto.getLottoNumbers()) {
      stringBuilder.append(integer);
      stringBuilder.append(COMMA + BLANK_SPACE);
    }
    stringBuilder.delete(stringBuilder.lastIndexOf(COMMA), stringBuilder.length());
    stringBuilder.append(RIGHT_BRACKET);

    System.out.println(stringBuilder);
  }

  public void printWinner(LottoWin lottoWin, int userAmount) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    System.out.println(WinnerMoney.FOURTH_WINNER_MONEY.getMatchNumberCount() + "개 일치 ("
        + WinnerMoney.FOURTH_WINNER_MONEY.getPrizeMoney() + "원)- " + lottoWin.getFourthWinnerCount()
        + "개");
    System.out.println(WinnerMoney.THIRD_WINNER_MONEY.getMatchNumberCount() + "개 일치 ("
        + WinnerMoney.THIRD_WINNER_MONEY.getPrizeMoney() + "원)- " + lottoWin.getThirdWinnerCount()
        + "개");
    System.out.println(WinnerMoney.SECOND_WINNER_MONEY.getMatchNumberCount() + "개 일치 ("
        + WinnerMoney.SECOND_WINNER_MONEY.getPrizeMoney() + "원)- " + lottoWin.getSecondWinnerCount()
        + "개");
    System.out.println(WinnerMoney.FIRST_WINNER_MONEY.getMatchNumberCount() + "개 일치 ("
        + WinnerMoney.FIRST_WINNER_MONEY.getPrizeMoney() + "원)- " + lottoWin.getFirstWinnerCount()
        + "개");

    double earningMoney =
        (lottoWin.getFirstWinnerCount() * WinnerMoney.FIRST_WINNER_MONEY.getPrizeMoney()) + (
            lottoWin.getSecondWinnerCount() * WinnerMoney.SECOND_WINNER_MONEY.getPrizeMoney()) + (
            lottoWin.getThirdWinnerCount() * WinnerMoney.THIRD_WINNER_MONEY.getPrizeMoney()) + (
            lottoWin.getFourthWinnerCount() * WinnerMoney.FOURTH_WINNER_MONEY.getPrizeMoney());
    double earningsRate = earningMoney / userAmount;
    System.out.println("총 수익률은 " + String.format("%.2f", earningsRate) + "입니다.");
  }
}
