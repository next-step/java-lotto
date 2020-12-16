package lotto.view;

import java.util.List;

import lotto.modal.Lotto;
import lotto.modal.Money;

public class UserView {

	private UserView() {
		throw new AssertionError();
	}

	public static Money getUserInputMoney() {

		UserOutput.printUserInputMoney();

		return new Money(getUserInputSystem());
	}

	public static String getUserInputLotto() {

		UserOutput.printUserInputLotto();

		return getUserInputSystem();
	}

	public static void printLottoPackage(List<Lotto> lottoPackage) {

		UserOutput.printLottoCount(lottoPackage.size());
		UserOutput.printLottoPackage(lottoPackage);
	}

	public static void printErrorMsg(String message) {

		calculator.view.UserOutput.printUserErrorMsg(message);
	}

	private static String getUserInputSystem() {

		return UserInput.userInputString();
	}

}
