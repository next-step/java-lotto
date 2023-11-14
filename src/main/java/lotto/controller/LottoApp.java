package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottoGame;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;

public class LottoApp {
    public static void main(String[] args) {
        Amount purchaseAmount = new Amount(InputView.inputPurchaseAmount());

        final LottoGame lottoGame = new LottoGame(purchaseAmount);

        final int purchaseCount = lottoGame.purchaseCount();
        ResultView.purchaseCountPrint(purchaseCount);
        ResultView.print(lottoGame.toString());

        String winningNumberText = InputView.inputWinningNumber();
        final Winning winner = lottoGame.draw(winningNumberText);
        ResultView.winnerPrint(winner);

        final double returnRate = winner.getReturnRate(purchaseAmount);
        ResultView.returnRatePrint(returnRate);
    }
}
