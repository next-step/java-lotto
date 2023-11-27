package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int amount = inputView.purchase();
        Lottos lottos = new LottoGenerator(amount, new RandomLottoNumbers()).generate();
        resultView.showLottos(lottos);

        Lotto winningLotto = inputView.winningLotto();
        resultView.winningStats(new LottosResult(lottos, winningLotto));
    }
}
