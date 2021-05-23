package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

	private RandomNumbersGenerator randomNumbersGenerator;

	public LottoGameController(RandomNumbersGenerator randomNumbersGenerator) {
		this.randomNumbersGenerator = randomNumbersGenerator;
	}

	public void play() {

		//로또구입
		int purchaseAmount = InputView.inputPurchaseAmount();
		LottoGame lottoGame = new LottoGame();
		Lottos lottos = lottoGame.purchaseLottos(new PuchaseAmount(purchaseAmount), this.randomNumbersGenerator);
		InputView.printPurchaseLottos(lottos);

		//당첨확인
		List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
		LottoResults lottoResults = lottos.match(new Lotto(winningLottoNumbers));
		ResultView.printLottoResult(lottoResults);

	}

}
