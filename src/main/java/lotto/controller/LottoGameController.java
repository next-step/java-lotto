package lotto.controller;

import lotto.domain.LottoBallMachine;
import lotto.domain.LottoGames;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

  public void start() {
    InputView inputView = new InputView();
    Money money = inputView.inputMoney();

    LottoBallMachine lottoBallMachine = new LottoBallMachine();
    lottoBallMachine.initialize();

    LottoStore lottoStore = new LottoStore(lottoBallMachine);
    LottoGames lottoGames = lottoStore.sell(money);

    ResultView resultView = new ResultView();
    resultView.printBuyingLottoGame(lottoGames);








  }

}
