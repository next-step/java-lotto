package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.Winner;
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
        final Winner winner = lottoGame.draw(winningNumberText);
        ResultView.winnerPrint(winner);

    }
}
