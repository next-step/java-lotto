package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        final Amount purchaseAmount = Amount.of(InputView.inputPurchaseAmount());
        final Amount manualLottoCount = Amount.of(InputView.inputManualLottoCount());

        List<Lotto> manualLottos = InputView.inputManualLotto(manualLottoCount);
        ResultView.purchaseCountPrint(manualLottoCount, purchaseAmount);

        Amount autoPurchaseAmount = purchaseAmount.minus(manualLottoCount.multiply(Amount.lotto()));
        final LottoGame lottoGame = new LottoGame(manualLottos, autoPurchaseAmount);
        ResultView.print(lottoGame.toString());

        String winningNumberText = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();

        final Winning winner = lottoGame.draw(winningNumberText, bonusNumber);
        ResultView.print(winner.toString());

        final double returnRate = winner.getReturnRate(purchaseAmount);
        ResultView.returnRatePrint(returnRate);
    }
}
