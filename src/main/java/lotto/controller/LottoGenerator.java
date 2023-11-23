package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGenerator {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGenerator(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Lottos lottos = new Lottos(inputView.purchaseGuide());
        resultView.lottos(lottos);
    }
}
