package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoUser;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

	private static LottoUser user;
	private static Lotto winningLotto;
	private static LottoNumber bonusNumber;

	private LottoGame() {

	}

	public static void start() {
		inputPurchaseLotto();
		inputManualLottos();
		purchaseAutoLottos();
		outputPurchaseLottosResult();
		outputUserLottoStatus();
		inputLastWeekWinningNumber();
		inputBonusNumber();
		outputResult();
	}

	private static void inputPurchaseLotto() {
		int purchasePrice = LottoInputView.inputPurchaseLottoPrice();
		user = new LottoUser(purchasePrice);
	}

	private static void inputManualLottos() {
		List<String> manualLottos = LottoInputView.inputManualLottoNumber(LottoInputView.inputManualLottoCount());
		user.buyManualLottos(LottoUtils.getStringListToLottos(manualLottos));
	}

	private static void purchaseAutoLottos() {
		user.buyGenerateLottos();
	}

	private static void outputPurchaseLottosResult() {
		LottoOutputView.printPurchaseLottoResult(user.getAutoLottoCount(), user.getManualLottoCount());
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
