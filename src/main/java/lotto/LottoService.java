package lotto;

import lotto.view.Outputview;
import lotto.view.UserInputProcessor;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        UserMoneyInput userInput = UserInputProcessor.getMoneyInput();
        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        Outputview.printPurchasedAmount(purchasedAmount);

        for (int i = 0; i < purchasedAmount; i++) {
            Outputview.printLotto(Lotto.create());
        }

        WinnerNumberInput winnerNumberInput = UserInputProcessor.getWinnerInput();
    }
}
