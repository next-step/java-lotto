package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void start() {
        int purchaseAmount = InputView.acceptPuchaseAmount();

        String[] winningNumber = InputView.acceptWinningNumber();
    }
}
