package controller;

import view.InputView;
import view.ResultView;

public class LottoController {

    public static void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        ResultView.purchaseResult(purchaseAmount / 1000);
    }
}
