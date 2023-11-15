package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    public LottoController() {

    }

    public static void run() {
        int amount = InputView.inputAmount();
        OutputView.outputQuantity(amount);

        LottoMachine lottoMachine = new LottoMachine(amount);
        lottoMachine.start();
    }
}
