package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoUser;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

	private static LottoUser user = new LottoUser();
	private static Lotto winningLotto;
	private static LottoNumber bonusNumber;

	private LottoGame() {

	}

	public static void start() {
		inputPurchaseLotto();
		outputUserLottoStatus();
		inputLastWeekWinningNumber();
		inputBonusNumber();
		outputResult();
	}

	private static void inputPurchaseLotto() {
		int purchasePrice = LottoInputView.inputPurchaseLottoPrice();
		user.buyGenerateLottos(purchasePrice);
	}

	private static void outputUserLottoStatus() {
		LottoOutputView.printPurchaseLottoCount(user.getLottoCount());
		LottoOutputView.printLottos(user.getUserLottos());
	}

	private static void inputLastWeekWinningNumber() {
		winningLotto = LottoUtils.getStringToLotto(LottoInputView.inputWinningLotto());
	}

	private static void inputBonusNumber() {
		bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());
		if(winningLotto.containNumber(bonusNumber)){
			inputBonusNumber();
		}
	}

	private static void outputResult() {
		LottoResult lottoResult = user.getUserLottoResult(winningLotto, bonusNumber);
		LottoOutputView.printWinningStatistics(lottoResult.getLottoRankCount());
		LottoOutputView.printYield(lottoResult.getYield());
	}
}
