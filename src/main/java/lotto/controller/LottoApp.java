package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        final LottoGame lottoGame = new LottoGame(purchaseAmount);

        final int purchaseCount = lottoGame.purchaseCount();
        ResultView.purchaseCountPrint(purchaseCount);
        ResultView.print(lottoGame.toString());

        String winningNumberText = InputView.inputWinningNumber();

    }
}
