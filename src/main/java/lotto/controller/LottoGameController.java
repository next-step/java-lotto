package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumbersGenerator;
import lotto.service.InputService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

	private InputService lottoInputService;
	private RandomNumbersGenerator randomNumbersGenerator;

	public LottoGameController(InputService lottoInputService, RandomNumbersGenerator randomNumbersGenerator) {
		this.lottoInputService = lottoInputService;
		this.randomNumbersGenerator = randomNumbersGenerator;
	}

	public void play() {

		//로또구입
		int purchaseAmount = this.lottoInputService.inputPurchaseAmount();
		LottoGame lottoGame = new LottoGame();
		List<LottoNumbers> lottos = lottoGame.purchaseLottos(purchaseAmount, this.randomNumbersGenerator);
		InputView.printPurchaseLottos(lottos);

		//당첨확인
		List<Integer> winLottoNumbers = this.lottoInputService.inputWinLottoNumbers();
		LottoResult lottoResult = new LottoResult(lottos, new LottoNumbers(winLottoNumbers));
		ResultView.printLottoResult(lottoResult);

	}

}
