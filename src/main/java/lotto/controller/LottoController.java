package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoGame lottoGame = LottoGame.of(purchaseAmount);
        ResultView.printPurchaseLottoCount(lottoGame.getCount());
    }
}
