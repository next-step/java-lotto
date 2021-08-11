package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    public void playLotto() {
        int lottoCount = InputView.buyLotto();
        String winningNumber = InputView.inputWinningNumber();
        System.out.println(winningNumber);
    }
}
