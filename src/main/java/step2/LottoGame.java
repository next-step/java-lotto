package step2;

import step2.model.LottoStore;
import step2.model.LottoWin;
import step2.model.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGame {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int userAmount = inputView.inputUserAmount();

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.purchase(userAmount);

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lottos);

    String[] lottowinningNumbers = inputView.inputLottoWinningNumber();
    LottoWin lottoWin = lottoStore.draw(lottos, lottowinningNumbers);

    resultView.printWinner(lottoWin, userAmount);
  }
}
