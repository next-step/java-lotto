package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.service.InputService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

	private InputService lottoInputService;

	public LottoGameController() {
		this.lottoInputService = new InputService();
	}

	public void play() {

		//로또구입
		int purchaseAmount = this.lottoInputService.inputPurchaseAmount();
		LottoGame lottoGame = new LottoGame(purchaseAmount);
		InputView.printPurchaseLottos(lottoGame.getLottos());

		//당첨확인
		List<Integer> winLottoNumbers = this.lottoInputService.inputWinLottoNumbers();
		LottoResult lottoResult = lottoGame.findWinningResult(new LottoNumbers(winLottoNumbers));
		ResultView.printLottoResult(lottoResult);

	}

}
