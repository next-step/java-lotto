package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    LottoGame lottoGame = new LottoGame(InputView.getInputMoney());
    ResultView.printPurchasedLottos(lottoGame.getLottos());

    WinningResult winningResult = lottoGame.getWinningResult(InputView.getWinningLotto());
    ResultView.printWinningResult(winningResult);
  }
}
