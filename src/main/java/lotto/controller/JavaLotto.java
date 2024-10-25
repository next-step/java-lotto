package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultStatistic;
import lotto.domain.Lottos;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class JavaLotto {

    private final InputView inputView;
    private final ResultView resultView;

    JavaLotto(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void playLotto() {
        int purchaseAmount = inputView.inputPurchaseAmountGuide();
        int numberOfManualLotto = inputView.inputManualLottoPurchaseAmount();

        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, numberOfManualLotto);

        Lottos manual = inputView.inputManualLottoGuide(purchaseInfo);
        int numberOfAutoLotto = purchaseInfo.getNumberOfAutoPurchase();
        Lottos lottos = Lottos.createLottos(manual, numberOfAutoLotto);

        resultView.printPurchaseLottoResult(lottos, purchaseInfo);

        Lotto winningLotto = inputView.inputWinnerNumber();
        LottoNumber bonusLottoNumber = inputView.inputBonusNumber();
        WinningLotto winningLottoInfo = new WinningLotto(winningLotto, bonusLottoNumber);
        LottoResultStatistic lottoResultStatistic = lottos.getResultStatistic(winningLottoInfo);

        resultView.printResult(lottoResultStatistic, purchaseInfo);
    }

}
