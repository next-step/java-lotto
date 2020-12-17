package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lotto.modal.Lotto;
import lotto.modal.LottoRank;
import lotto.modal.Money;

public class UserView {

	private UserView() {
		throw new AssertionError();
	}

	public static Money getUserInputMoney() {
		UserOutput.printUserInputMoney();
		return new Money(getUserInputSystem());
	}

	public static Lotto getUserInputLotto() {
		UserOutput.printUserInputLotto();
		return Lotto.generateWinnerLotto(getUserInputSystem());
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

	public static void printLottoResultRank(Map<LottoRank, Integer> lottoResult) {
		UserOutput.printLottoRankResult(lottoResult);
	}

	public static void printLottoResultYield(BigDecimal yield) {
		UserOutput.printLottoYield(yield);
	}
}
