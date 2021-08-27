package step2;

import step2.model.lotto.Lottos;
import step2.model.lottostore.LottoStore;
import step2.model.lottostore.LottoWin;
import step2.model.view.Input;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGame {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Input userInput = inputView.getUserInput();

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore
        .purchase(userInput.getUserAmount(), userInput.getUserManualLottoNumbers());

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lottos, userInput);

    inputView.setUserWinningInput(userInput);
    LottoWin lottoWin = lottoStore.draw(lottos, userInput);

    resultView.printWinner(lottoWin, userInput);
  }
}
