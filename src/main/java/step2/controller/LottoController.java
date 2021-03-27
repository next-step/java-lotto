package step2.controller;

import step2.domain.Money;
import step2.view.InputView;

public class LottoController {
    private final Money purchasePrice;

    public LottoController() {
        this.purchasePrice = Money.from(InputView.inputPrice());
    }

    public void run() {

    }
}
