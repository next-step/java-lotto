package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        //buyLotto();
        int money = InputView.inputMoney();
        ResultView.printCheckPurchaseMessage(money/1000);

        //checkLottoResult();
    }
}
