package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    Money money = InputView.getInputMoney();
    LottoGame lottoGame = new LottoGame(money);

    ResultView.printPurchasedLottos(lottoGame.getLottos());

    Lotto winningLotto = InputView.getWinningLotto();
    WinningResult winningStatics = lottoGame.getWinningStatics(winningLotto);

    ResultView.printWinningStatics(winningStatics);
  }
}
