package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

	private InputView inputView;
	private RandomNumbersGenerator randomNumbersGenerator;

	public LottoGameController(InputView inputView, RandomNumbersGenerator randomNumbersGenerator) {
		this.inputView = inputView;
		this.randomNumbersGenerator = randomNumbersGenerator;
	}

	public void play() {

		//로또구입
		int purchaseAmount = this.inputView.inputPurchaseAmount();
		LottoGame lottoGame = new LottoGame();
		List<Lotto> lottos = lottoGame.purchaseLottos(new PuchaseAmount(purchaseAmount), this.randomNumbersGenerator);
		InputView.printPurchaseLottos(lottos);

		//당첨확인
		List<Integer> winningLottoNumbers = this.inputView.inputWinningLottoNumbers();
		LottoResult lottoResult = new LottoResult(lottos, new Lotto(winningLottoNumbers));
		ResultView.printLottoResult(lottoResult);

	}

}
