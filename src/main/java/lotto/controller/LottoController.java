package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.RandomNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        LottoGame lottoGame = new LottoGame(inputView.inputMoney());

        resultView.printOfBuyLotto(lottoGame, randomNumberStrategy);
        resultView.printWinningResult(lottoGame, inputView.inputWinningNumber());
    }
}
