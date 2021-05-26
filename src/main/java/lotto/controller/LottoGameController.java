package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

	private RandomNumbersGenerator randomNumbersGenerator;

	public LottoGameController(RandomNumbersGenerator randomNumbersGenerator) {
		this.randomNumbersGenerator = randomNumbersGenerator;
	}

	public void play() {

		Lottos lottos = new LottoGame().purchaseLottos(InputView.inputPurchaseAmount(), this.randomNumbersGenerator);
		InputView.printPurchaseLottos(lottos);

		LottoResults lottoResults = lottos.findResult(InputView.inputWinningLotto());
		ResultView.printLottoResult(lottoResults);

	}

}
