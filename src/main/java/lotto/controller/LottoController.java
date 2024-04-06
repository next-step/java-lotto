package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
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
        lottoGame.createManualLotto(inputView.inputManualLotto());
        lottoGame.createAutoLotto(randomNumberStrategy);

        resultView.printOfBuyLotto(lottoGame);
        final List<Rank> ranks = lottoGame.match(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        resultView.printWinningResult(LottoResult.matchResult(ranks));
        resultView.printProfit(lottoGame.calculateProfit(ranks));
    }
}
