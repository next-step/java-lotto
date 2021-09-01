package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    LottoGame lottoGame = new LottoGame(InputView.inputMoney());
    ResultView.printPurchasedLottos(lottoGame.lottos());

    WinningResult winningResult = lottoGame.winningResult(InputView.winningInfo());
    ResultView.printWinningResult(winningResult);
  }
}
