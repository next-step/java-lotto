package lotto.view;

import java.math.BigDecimal;
import java.util.List;

import lotto.modal.Lotto;
import lotto.modal.LottoNumber;
import lotto.modal.Money;
import lotto.modal.WinnerLotto;

public class UserView {

	private UserView() {
		throw new AssertionError();
	}

	public static Money getUserInputMoney() {
		UserOutput.printUserInputMoney();
		return new Money(getUserInputSystem());
	}

	public static WinnerLotto getUserInputLotto() {
		UserOutput.printUserInputWinnerLotto();
		Lotto winnerLotto = Lotto.generateWinnerLotto(getUserInputSystem());

		UserOutput.printUserInputBonusNumber();
		LottoNumber bonusNumber = new LottoNumber(getUserInputSystem());

		return new WinnerLotto(winnerLotto, bonusNumber);
	}

	public static void printLottoPackage(List<Lotto> lottoPackage) {
		UserOutput.printLottoCount(lottoPackage.size());
		UserOutput.printLottoPackage(lottoPackage);
	}

	public static void printErrorMsg(String message) {
		UserOutput.printUserErrorMsg(message);
	}

	private static String getUserInputSystem() {
		return UserInput.userInputString();
	}

	public static void printLottoResultRank(List<String> lottoRanks) {
		UserOutput.printLottoRankResult(lottoRanks);
	}

	public static void printLottoResultYield(BigDecimal yield) {
		UserOutput.printLottoYield(yield);
	}
}
