package lotto.controller;

import lotto.model.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public final class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController() {
        this.lottoInputView = LottoInputView.getInstance();
        this.lottoOutputView = LottoOutputView.getInstance();
    }

    public void run() {
        final LottoMoney purchase = LottoMoney.valueOf(lottoInputView.inputPurchase());
        final long manualLottosSize = lottoInputView.inputManualLottosSize();
        final LottosSize lottosSize = LottosSize.of(purchase, manualLottosSize);
        final Lottos lottos = Lottos.create(lottoInputView.inputManualLottosNumbers(manualLottosSize), lottosSize);

        printLottosInformation(purchase, lottosSize, lottos);

        final LottoResult lottoResult = LottoResult.of(Ranks.of(resultRanksWithWinningLotto(lottos)), purchase);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private List<Rank> resultRanksWithWinningLotto(final Lottos lottos) {
        final Lotto winningNumbers = Lotto.create(lottoInputView.inputWinningNumbers());
        final LottoNumber bonusBall = LottoNumber.of(lottoInputView.inputBonusBall());
        final WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusBall);

        return lottos.matchWinningNumbers(winningLotto);
    }

    private void printLottosInformation(final LottoMoney purchase, final LottosSize lottosSize, final Lottos lottos) {
        lottoOutputView.printSizeOfLottos(lottosSize);
        lottoOutputView.printChangeOfPurchase(purchase.change(Lotto.COST));
        lottoOutputView.printBuyingLotto(lottos);
    }
}
