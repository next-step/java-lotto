package lotto.controller;

import lotto.domain.LottoResultStatistic;
import lotto.domain.LottoShuffleGenerator;
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

        PurchaseInfo purchaseInfo
                = new PurchaseInfo(inputView.inputPurchaseAmountGuide(),inputView.inputManualLottoPurchaseAmount());

        Lottos lottos = inputView.inputManualLottoGuide(purchaseInfo.getNumberOfManualPurchase(), purchaseInfo);
        lottos.additionalLottos(Lottos.createLottos(purchaseInfo.getNumberOfAutoPurchase(), LottoShuffleGenerator.getLottoShuffleGenerator()));

        resultView.NumberOfLotto(purchaseInfo);
        resultView.printPurchasedLottos(lottos);

        LottoResultStatistic lottoResultStatistic
                = lottos.getResultStatistic(new WinningLotto(inputView.inputWinnerNumber(), inputView.inputBonusNumber()));

        resultView.printResult(lottoResultStatistic, purchaseInfo);

    }

}
