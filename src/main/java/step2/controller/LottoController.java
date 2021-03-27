package step2.controller;

import step2.domain.Lottos;
import step2.domain.Money;
import step2.generator.LottoNumberGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    private final Money amount;
    private final Lottos lottos;

    public LottoController() {
        this.amount = Money.from(InputView.inputAmount());
        this.lottos = Lottos.from(new LottoNumberGenerator(), amount);
    }

    public void run() {
        ResultView.printPurchaseCount(lottos);
        ResultView.printAllLotto(lottos);
    }
}
