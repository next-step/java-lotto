package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputview;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputview = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
    }
}
