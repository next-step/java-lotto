package lotto;

import lotto.view.Outputview;
import lotto.view.UserInputProcessor;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        UserMoneyInput userInput = UserInputProcessor.getMoneyInput();
        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        Outputview.printPurchasedAmount(purchasedAmount);

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchasedAmount; i++) {
            Lotto purchasedLotto = Lotto.create();
            Outputview.printLotto(purchasedLotto);
            purchasedLottos.add(purchasedLotto);
        }

        WinnerNumberInput winnerNumberInput = UserInputProcessor.getWinnerInput();
        Lotto winningLotto = winnerNumberInput.getWinningLotto();

        LottoResult lottoResult = LottoResult.from(purchasedLottos, winningLotto);
        Outputview.printResult(lottoResult);
    }
}
