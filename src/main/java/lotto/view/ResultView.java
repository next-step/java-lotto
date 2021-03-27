package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;

public class ResultView {

  private static final String BUY_COMMENT = "개를 구매했습니다.";

  public void printBuyingLottoGame(LottoGames lottoGames) {
    printLottoBuySize(lottoGames);
    printLottoDrawResult(lottoGames);
  }

  private void printLottoBuySize(LottoGames lottoGames) {
    System.out.println(lottoGames.size() + BUY_COMMENT);
  }

  private void printLottoDrawResult(LottoGames lottoGames) {
    StringBuilder builder;
    for (LottoGame lottoGame : lottoGames.getLottoGames()) {
      builder = new StringBuilder();
      builder.append("[");
      builder.append(lottoGame.getLottoBallNumbersString());
      builder.append("]");
      System.out.println(builder.toString());
    }

  }
}
