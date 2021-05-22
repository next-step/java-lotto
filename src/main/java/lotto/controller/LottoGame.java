package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoUser;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

	private LottoUser user;
	private LottoInputView input;
	private LottoOutputView output;
	private Lotto winningLotto;

	public LottoGame() {
		this.user = new LottoUser();
		this.input = new LottoInputView();
		this.output = new LottoOutputView();
	}

	public void start() {
		inputPurchaseLotto();
		outputUserLottoStatus();
		inputLastWeekWinningNumber();
		outputResult();
	}

	private void inputPurchaseLotto() {
		int purchasePrice = this.input.inputPurchaseLottoPrice();
		this.user.buyGenerateLottos(purchasePrice);
	}

	private void outputUserLottoStatus() {
		this.output.printPurchaseLottoCount(this.user.getLottoCount());
		output.printLottos(this.user.getUserLottos());
	}

	private void inputLastWeekWinningNumber() {
		this.winningLotto = LottoUtils.getStringToLotto(this.input.inputWinningLotto());
	}

	private void outputResult() {
		LottoResult lottoResult = this.user.getUserLottoResult(this.winningLotto);
		this.output.printWinningStatistics(lottoResult.getLottoRankCount());
		this.output.printYield(lottoResult.getYield());
	}
}
