package step2.controller;

import step2.domain.Lotto;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        Lotto lotto = new Lotto(purchasePrice);

        ResultView.printPurchaseCount(lotto.getCount());
    }
}
