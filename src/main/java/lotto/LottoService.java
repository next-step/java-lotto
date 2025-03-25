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

        // 구입한 로또와 당첨번호를 비교
        LottoResult lottoResult = new LottoResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            lottoResult.addLottoResult(purchasedLotto, winningLotto);
        }
        Outputview.printResult(lottoResult);
    }
}
