package lotto;

import lotto.view.Outputview;
import lotto.view.UserInputProcessor;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        UserInput userInput = UserInputProcessor.getInput();
        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        Outputview.printPurchasedAmount(purchasedAmount);
    }
}
