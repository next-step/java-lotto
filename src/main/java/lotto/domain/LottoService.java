package lotto.domain;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoSeller;
import lotto.view.model.UserMoneyInput;
import lotto.view.model.WinningNumberInput;
import lotto.view.Outputview;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        UserMoneyInput userInput = InputView.getMoneyInput();
        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        Outputview.printPurchasedAmount(purchasedAmount);

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchasedAmount; i++) {
            Lotto purchasedLotto = Lotto.create();
            Outputview.printLotto(purchasedLotto);
            purchasedLottos.add(purchasedLotto);
        }

        WinningNumberInput winnerNumberInput = InputView.getWinnerInput();
        Lotto winningLotto = winnerNumberInput.getWinningLotto();

        LottoResult lottoResult = LottoResult.from(purchasedLottos, winningLotto);
        Outputview.printResult(lottoResult);
    }
}
