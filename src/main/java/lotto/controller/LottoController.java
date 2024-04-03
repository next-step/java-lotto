package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.RandomNumberStrategy;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        LottoGame lottoGame = new LottoGame(inputView.inputMoney());
        lottoGame.createLotto(randomNumberStrategy);

        resultView.printOfBuyLotto(lottoGame);
        List<Rank> userLottoRanks = lottoGame.match(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        resultView.printWinningResult(userLottoRanks);
        resultView.printProfit(lottoGame.calculateProfit(userLottoRanks));
    }
}
