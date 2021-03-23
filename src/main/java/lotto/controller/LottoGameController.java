package lotto.controller;

import java.util.List;
import lotto.domain.LottoBall;
import lotto.domain.LottoBallFactory;
import lotto.domain.LottoBalls;
import lotto.domain.LottoGame;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {

  public void start() {
    InputView inputView = new InputView();
    Money money = inputView.inputMoney();

    LottoBalls lottoBalls = LottoBallFactory.initialize();
    LottoStore lottoStore = new LottoStore();
    List<LottoGame> lottoGames = lottoStore.sell(money);

    lottoGames.forEach( game -> {
      game.start(lottoBalls);
    });





  }

}
