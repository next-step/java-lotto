package step2;

import step2.model.LottoWins;
import step2.model.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGame {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int userAmount = inputView.inputUserAmount();

    Lottos lottos = new Lottos();
    lottos.purchase(userAmount);

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lottos);

    String[] lottowinningNumbers = inputView.inputLottoWinningNumber();

    LottoWins lottoWins = new LottoWins(lottowinningNumbers);
    lottoWins.drawLotto(lottos);

    resultView.printWinner(lottoWins, lottos, userAmount);
  }
}
