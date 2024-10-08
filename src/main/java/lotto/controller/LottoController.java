package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public LottoController() {
    }
    public void run(){
        ResultView.printPurchaseLottoCount(InputView.getPurchasePrice());
    }
}
