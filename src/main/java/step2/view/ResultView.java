package step2.view;

import step2.model.Lotto;
import step2.model.LottoWin;
import step2.model.LottoWins;
import step2.model.Lottos;

public class ResultView {

  private final static String LEFT_BRACKET = "[";
  private final static String RIGHT_BRACKET = "]";
  private final static String COMMA = ",";
  private final static String BLANK_SPACE = " ";


  private final static int FOURTH_WINNER_MONEY = 5000;
  private final static int THIRD_WINNER_MONEY = 50000;
  private final static int SECOND_WINNER_MONEY = 1500000;
  private final static int FIRST_WINNER_MONEY = 2000000000;


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

  public void printWinner(LottoWins lottoWins, Lottos lottos, int userAmount) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    LottoWin lottoWin = lottoWins.getLottoWin(lottos);
    int fourthWinnerCount = lottoWin.getFourthWinnerCount();
    int thirdhWinnerCount = lottoWin.getThirdWinnerCount();
    int secondhWinnerCount = lottoWin.getSecondWinnerCount();
    int firstWinnerCount = lottoWin.getFirstWinnerCount();

    System.out.println("3개 일치 (" + FOURTH_WINNER_MONEY + "원)- " + fourthWinnerCount + "개");
    System.out.println("4개 일치 (" + THIRD_WINNER_MONEY + "원)- " + thirdhWinnerCount + "개");
    System.out.println("5개 일치 (" + SECOND_WINNER_MONEY + "원)- " + secondhWinnerCount + "개");
    System.out.println("6개 일치 (" + FIRST_WINNER_MONEY + "원)- " + firstWinnerCount + "개");

    double earningMoney =
        (firstWinnerCount * FIRST_WINNER_MONEY) + (secondhWinnerCount * SECOND_WINNER_MONEY) + (
            thirdhWinnerCount * THIRD_WINNER_MONEY) + (fourthWinnerCount * FOURTH_WINNER_MONEY);
    double earningsRate = earningMoney / userAmount;
    System.out.println("총 수익률은 " + String.format("%.2f", earningsRate) + "입니다.");
  }
}
