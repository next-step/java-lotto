package lotto.controller;

import lotto.model.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public final class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController() {
        this.lottoInputView = LottoInputView.getInstance();
        this.lottoOutputView = LottoOutputView.getInstance();
    }

    public void run() {
        final Money purchase = Money.valueOf(lottoInputView.inputPurchase());
        final long lottosSize = purchase.quotient(Lotto.COST);
        final Lottos lottos = Lottos.create(
                lottosSize,
                RandomNumbersGenerator.getInstance()
        );

        printPurchaseInformation(purchase, lottos);

        final Lotto winningNumbers = Lotto.create(lottoInputView.inputWinningNumbers());
        final LottoNumber bonusBall = LottoNumber.of(lottoInputView.inputBonusBall());
        final WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusBall);

        printLottoResult(purchase, lottos, winningLotto);
    }

    private void printLottoResult(final Money purchase, final Lottos lottos, final WinningLotto winningLotto) {
        final LottoResult lottoResult = LottoResult.of(lottos.matchWinningNumbers(winningLotto), purchase);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private void printPurchaseInformation(final Money purchase, final Lottos lottos) {
        lottoOutputView.printSizeOfLottos(lottos);
        lottoOutputView.printChangeOfPurchase(purchase.remainder(Lotto.COST));
        lottoOutputView.printBuyingLotto(lottos);
    }
}
