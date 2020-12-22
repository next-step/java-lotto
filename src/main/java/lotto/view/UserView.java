package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lotto.modal.GameCondition;
import lotto.modal.Lotto;
import lotto.modal.LottoNumber;
import lotto.modal.WinnerLotto;

public class UserView {

	private UserView() {
		throw new AssertionError();
	}

	public static String inputGameMoney() {
		UserOutput.printUserInputMoney();
		return userInputString();
	}

	public static WinnerLotto inputWinnerLotto() {
		UserOutput.printUserInputWinnerLotto();
		Lotto winnerLotto = Lotto.generateLotto(userInputString());

		UserOutput.printUserInputBonusNumber();
		LottoNumber bonusNumber = new LottoNumber(userInputString());

		return new WinnerLotto(winnerLotto, bonusNumber);
	}

	public static void printLottoPackage(GameCondition condition, List<Lotto> lottoPackage) {
		UserOutput.printLottoCount(condition.getCount(), condition.getRandomCount());
		UserOutput.printLottoPackage(lottoPackage);
	}

	public static void printLottoResultRank(List<String> lottoRanks) {
		UserOutput.printLottoRankResult(lottoRanks);
	}

	public static void printLottoResultYield(BigDecimal yield) {
		UserOutput.printLottoYield(yield);
	}

	public static void printErrorMsg(String message) {
		UserOutput.printUserErrorMsg(message);
	}

	public static String inputManualCount() {
		UserOutput.printManualLottoCount();
		return userInputString();
	}

	public static List<Lotto> inputManualLotto(int repeatNumber) {
		List<Lotto> manualLotto = new ArrayList<>();
		if (repeatNumber != 0) {
			UserOutput.printUserInputManualLotto();
		}
		for (int i = 0; i < repeatNumber; i++) {
			manualLotto.add(Lotto.generateLotto(userInputString()));
		}
		return manualLotto;
	}

	private static String userInputString() {
		return UserInput.inputString();
	}
}
