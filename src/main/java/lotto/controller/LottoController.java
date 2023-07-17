package lotto.controller;

import lotto.model.domain.*;
import lotto.model.service.LottoGame;
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
        final LottoGame lottoGame = new LottoGame();

        final LottoMoney purchase = LottoMoney.valueOf(lottoInputView.inputPurchase());
        final long manualLottosSize = lottoInputView.inputManualLottosSize();
        final LottosSize lottosSize = LottosSize.of(purchase, manualLottosSize);
        final List<List<Integer>> manualLottos = lottoInputView.inputManualLottosNumbers(manualLottosSize);

        lottoGame.buyLottos(manualLottos, lottosSize);
        printLottosInformation(purchase, lottosSize, lottoGame.getLottos());

        lottoGame.winningLotto(lottoInputView.inputWinningNumbers(),
                lottoInputView.inputBonusBall()
        );

        final LottoResult lottoResult = lottoGame.result(purchase);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private void printLottosInformation(final LottoMoney purchase, final LottosSize lottosSize, final Lottos lottos) {
        lottoOutputView.printSizeOfLottos(lottosSize);
        lottoOutputView.printChangeOfPurchase(purchase.change(Lotto.COST));
        lottoOutputView.printBuyingLotto(lottos);
    }
}
