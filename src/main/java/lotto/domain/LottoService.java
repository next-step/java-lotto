package lotto.domain;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoSeller;
import lotto.view.model.UserMoneyInput;
import lotto.domain.model.WinningLotto;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        List<Lotto> purchasedLottos = purchaseLotto();
        WinningLotto winningLotto = getWinningLotto();
        displayResult(purchasedLottos, winningLotto);
    }

    private List<Lotto> purchaseLotto() {
        UserMoneyInput userInput = InputView.getMoneyInput();

        int purchasedAmount = lottoSeller.getPurchasableLottoCount(userInput);
        OutputView.printPurchasedAmount(purchasedAmount);

        List<Lotto> purchasedLotto = lottoSeller.generateAndSell(purchasedAmount);
        OutputView.printLottos(purchasedLotto);

        return purchasedLotto;
    }

    private WinningLotto getWinningLotto() {
        return InputView.getWinnerInput();
    }

    private void displayResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);
        OutputView.printResult(lottoResult);
    }
}
