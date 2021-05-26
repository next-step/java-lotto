package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseHistory;
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
		user = new LottoUser();
	}

	public static void start() {
		purchaseLottos();
		getUserLottoStatus();
		inputLastWeekWinningNumber();
		inputBonusNumber();
		outputResult();
	}

	private static void purchaseLottos() {
		int purchasePrice = LottoInputView.inputPurchaseLottoPrice();
		List<String> manualLottos = LottoInputView.inputManualLottoNumber(LottoInputView.inputManualLottoCount());
		LottoPurchaseHistory lottoPurchaseHistory = user.buyLottos(LottoUtils.getStringListToLottos(manualLottos), purchasePrice);
		LottoOutputView.printPurchaseLottoResult(lottoPurchaseHistory.getAutoLottoCount(), lottoPurchaseHistory.getManualLottoCount());
	}

	private static void getUserLottoStatus() {
		LottoOutputView.printPurchaseLottoCount(user.getLottoCount());
		LottoOutputView.printLottos(user.getUserLottos());
	}

	private static void inputLastWeekWinningNumber() {
		winningLotto = LottoUtils.getStringToLotto(LottoInputView.inputWinningLotto());
	}

	private static void inputBonusNumber() {
		bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());
		if (winningLotto.containNumber(bonusNumber)) {
			inputBonusNumber();
		}
	}

	private static void outputResult() {
		LottoResult lottoResult = user.getUserLottoResult(winningLotto, bonusNumber);
		LottoOutputView.printWinningStatistics(lottoResult.getLottoRankCount());
		LottoOutputView.printYield(lottoResult.getYield());
	}
}
