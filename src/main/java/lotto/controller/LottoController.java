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
        lottoGame.createLotto(randomNumberStrategy);

        resultView.printOfBuyLotto(lottoGame);
        resultView.printWinningResult(lottoGame, inputView.inputWinningNumber(), inputView.inputBonusNumber());
    }
}
