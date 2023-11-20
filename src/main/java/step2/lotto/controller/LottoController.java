package step2.lotto.controller;

import step2.lotto.view.InputView;

public class LottoController {

    public static void run() {
        InputView inputView = new InputView();
        int inputMoney = inputView.inputMoney();
    }
}
