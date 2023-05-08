package lotto.controller;

import lotto.domain.LottoCalculator;
import lotto.domain.LottoGame;
import lotto.domain.LottoScore;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, ResultView resultView, LottoGame lottoGame) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGame = lottoGame;
    }

    public void buy() {
        lottoGame.buyLotto(inputView.price());
        inputView.buy(lottoGame.quantity());
        resultView.view(lottoGame.lottos());
    }

    public void result() {
        LottoScore lottoScore = lottoGame.score(inputView.result(), inputView.bonus());
        resultView.result(lottoScore);
        resultView.rate(LottoCalculator.rate(
                lottoScore.amount(),
                lottoGame.quantity()
        ));
    }
}
