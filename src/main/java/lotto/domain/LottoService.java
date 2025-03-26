package lotto.domain;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoSeller;
import lotto.view.model.UserMoneyInput;
import lotto.view.model.WinningNumberInput;
import lotto.view.Outputview;
import lotto.view.InputView;

import java.util.List;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        List<Lotto> purchasedLottos = purchaseLotto();
        Lotto winningLotto = getWinningLotto();
        displayResult(purchasedLottos, winningLotto);

    }

    private List<Lotto> purchaseLotto() {
        UserMoneyInput userInput = InputView.getMoneyInput();

        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        Outputview.printPurchasedAmount(purchasedAmount);

        List<Lotto> purchasedLotto = lottoSeller.generateAndSell(purchasedAmount);
        Outputview.printLottos(purchasedLotto);

        return purchasedLotto;
    }

    private Lotto getWinningLotto() {
        WinningNumberInput winnerNumberInput = InputView.getWinnerInput();
        return winnerNumberInput.getWinningLotto();
    }

    private void displayResult(List<Lotto> purchasedLottos, Lotto winningLotto) {
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);
        Outputview.printResult(lottoResult);
    }
}
