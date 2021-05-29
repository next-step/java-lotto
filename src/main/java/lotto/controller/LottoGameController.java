package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomNumbersGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    private RandomNumbersGenerator randomNumbersGenerator;

    public LottoGameController(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public void play() {
        PurchaseAmount purchaseAmount = InputView.inputPurchaseAmount();
        Lottos manualLottos = InputView.inputManualLottos();

        Lottos purchaseLottos = new Lottos(randomNumbersGenerator, purchaseAmount, manualLottos);
        InputView.printPurchaseQuantity(purchaseAmount, manualLottos);
        InputView.printPurchaseLottos(purchaseLottos);

        WinningLotto winningLotto = InputView.inputWinningLotto();
        LottoResults lottoResults = purchaseLottos.findResult(winningLotto);
        ResultView.printLottoResult(lottoResults);
    }

}
