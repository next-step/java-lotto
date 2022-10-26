package step2.controller;

import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

    public void start() {
        Lottos lottos = new Lottos(InputView.purchasePriceInput());
        purchaseOutput(lottos);
        InputView.winningNumbers();
    }

    private void purchaseOutput(Lottos lottos) {
        OutputView.lottoCountOutput(lottos);
        OutputView.lottoDetailOutput(lottos);
    }
}
