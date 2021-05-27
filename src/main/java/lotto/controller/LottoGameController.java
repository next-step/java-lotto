package lotto.controller;

import lotto.domain.*;
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

		PurchaseRequest purchaseRequest = new PurchaseRequest(purchaseAmount, manualLottos);
		PurchaseLottos purchaseLottos = new LottoGame().purchaseLottos(purchaseRequest, randomNumbersGenerator);
		InputView.printPurchaseLottos(purchaseLottos);

		WinningLotto winningLotto = InputView.inputWinningLotto();
		LottoResults lottoResults = purchaseLottos.findResult(winningLotto);
		ResultView.printLottoResult(lottoResults);

	}

}
