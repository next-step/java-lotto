package step2.view;

import step2.model.lotto.Lotto;
import step2.model.lotto.Lottos;
import step2.model.lottostore.LottoWin;
import step2.model.lottostore.WinnerMoney;
import step2.model.view.Input;

public class ResultView {

  private static final String LEFT_BRACKET = "[";
  private static final String RIGHT_BRACKET = "]";
  private static final String COMMA = ",";
  private static final String BLANK_SPACE = " ";

  public void printPurchasedLotto(Lottos lottos, Input userInput) {

    System.out.println(
        "수동으로 " + userInput.getUserManualLottoCount() + "장, 자동으로 " + (lottos.getLottosSize()
            - userInput.getUserManualLottoCount()) + "개를 구매했습니다.");

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      printLotto(lottos.getLotto(i));
    }

    System.out.println();
  }

  private void printLotto(Lotto lotto) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(LEFT_BRACKET);

    for (int i = 0; i < lotto.getLottoNos().getLottoNosSize(); i++) {
      stringBuilder.append(lotto.getLottoNos().getLottoNos(i).getLottoNum());
      stringBuilder.append(COMMA + BLANK_SPACE);
    }

    stringBuilder.delete(stringBuilder.lastIndexOf(COMMA), stringBuilder.length());
    stringBuilder.append(RIGHT_BRACKET);

    System.out.println(stringBuilder);
  }

  public void printWinner(LottoWin lottoWin, Input userInput) {

    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    double earningMoney = 0;
    for (WinnerMoney winnerMoney : WinnerMoney.values()) {
      printResult(winnerMoney, lottoWin);
      earningMoney += lottoWin.getWinnerCount(winnerMoney) * winnerMoney.getPrizeMoney();
    }

    double earningsRate = earningMoney / userInput.getUserAmount();
    System.out.println("총 수익률은 " + String.format("%.2f", earningsRate) + "입니다.");
  }

  private void printResult(WinnerMoney winnerMoney, LottoWin lottoWin) {
    if (winnerMoney.hasMatchBonusNumber()) {
      printBonusString(winnerMoney, lottoWin, "개 일치, 보너스 볼 일치 (");
      return;
    }

    System.out.println(winnerMoney.getMatchNumberCount() + "개 일치 ("
        + winnerMoney.getPrizeMoney() + "원)- " + lottoWin.getWinnerCount(winnerMoney)
        + "개");
  }

  private void printBonusString(WinnerMoney winnerMoney, LottoWin lottoWin, String s) {
    System.out.println(winnerMoney.getMatchNumberCount() + s
        + winnerMoney.getPrizeMoney() + "원)- " + lottoWin.getWinnerCount(winnerMoney)
        + "개");
  }
}
