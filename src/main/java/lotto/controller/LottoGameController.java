package lotto.controller;

import java.util.List;
import lotto.domain.LottoGames;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

  public void start() {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Money money = inputView.inputMoney();
    if (!money.availableBuyLotto()) {
      resultView.printUnavailableGame();
      return;
    }

    LottoStore lottoStore = new LottoStore();
    LottoGames lottoGames = lottoStore.sell(money);

    resultView.printBuyingLottoGame(lottoGames);

    List<Integer> winNumbers = inputView.inputWinNumbers();
    Statistics statistics = lottoGames.calculateStatistics(winNumbers);

    resultView.printLottoResult(money,statistics);


  }

}
