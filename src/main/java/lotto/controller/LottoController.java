package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        int buyAmount = inputView.inputBuyAmount();
    }
}
