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
        final int purchaseAmount = InputView.inputPurchaseAmount();
        final int manualLottoCount = InputView.inputManualLottoCount();

        List<Lotto> manualLottos = InputView.inputManualLotto(manualLottoCount);
        ResultView.purchaseCountPrint(manualLottoCount, purchaseAmount);

        int autoPurchaseAmount = purchaseAmount - (manualLottoCount * 1000);
        final LottoGame lottoGame = new LottoGame(manualLottos, new Amount(autoPurchaseAmount));
        ResultView.print(lottoGame.toString());

        String winningNumberText = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();

        final Winning winner = lottoGame.draw(winningNumberText, bonusNumber);
        ResultView.print(winner.toString());

        final double returnRate = winner.getReturnRate(new Amount(purchaseAmount));
        ResultView.returnRatePrint(returnRate);
    }
}
